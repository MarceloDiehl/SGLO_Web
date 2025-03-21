package br.com.senac.atividade_04_uc15.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class CadastroClienteDAO {

    public void Cadastrar(CadastroCliente cadastroCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cadastroCliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<CadastroCliente> listar(String pesquisarCPF) {
        EntityManager em = JPAUtil.getEntityManager();
        List CadastroCliente = null;
        try {
            String textoQuery = "SELECT c FROM CadastroCliente c WHERE (:CPF IS NULL OR c.CPF LIKE :CPF)";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("CPF", pesquisarCPF.isEmpty() ? null : "%" + pesquisarCPF + "%");

            CadastroCliente = consulta.getResultList();

        } finally {
            JPAUtil.closeEntityManager();
        }
        return CadastroCliente;

    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CadastroCliente c = em.find(CadastroCliente.class, id);
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
