package br.com.senac.atividade_04_uc15.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CadastroFuncionarioDAO {

    public void Cadastrar(CadastroFuncionario cadastroFuncionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cadastroFuncionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<CadastroFuncionario> listar(String pesquisarCPF) {
        EntityManager em = JPAUtil.getEntityManager();
        List CadastroFuncionario = null;
        try {
            String textoQuery = "SELECT f FROM CadastroFuncionario f WHERE (:CPF IS NULL OR f.CPF LIKE :CPF)";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("CPF", pesquisarCPF.isEmpty() ? null : "%" + pesquisarCPF + "%");

            CadastroFuncionario = consulta.getResultList();

        } finally {
            JPAUtil.closeEntityManager();
        }
        return CadastroFuncionario;

    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CadastroFuncionario f = em.find(CadastroFuncionario.class, id);
            if (f != null) {
                em.getTransaction().begin();
                em.remove(f);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public static CadastroFuncionario validarFuncionarioSeguro(CadastroFuncionario cadastroFuncionario) {
        EntityManager em = JPAUtil.getEntityManager();
        CadastroFuncionario funcionarioEncontrado = null;

        try {
            String jpql = "SELECT f FROM CadastroFuncionario f WHERE f.email = :email AND f.senha = :senha";
            TypedQuery<CadastroFuncionario> query = em.createQuery(jpql, CadastroFuncionario.class);
            query.setParameter("email", cadastroFuncionario.getEmail());
            query.setParameter("senha", cadastroFuncionario.getSenha());

            List<CadastroFuncionario> resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                funcionarioEncontrado = resultado.get(0);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return funcionarioEncontrado;
    }

    public static String getMD5(String texto) {
        try {

            // O método estático getInstance é chamado com hash MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // O método digest() é chamado para calcular a hash da mensagem
            // E enfim temos o vetor da mensagem
            byte[] messageDigest = md.digest(texto.getBytes());

            // Convertemos o vetor de bytes em um BigInt
            BigInteger no = new BigInteger(1, messageDigest);

            // A mensagem em BigInt é convertida para hexadecimal
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // Em caso de erro, é lançada uma exceção
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
