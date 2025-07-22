package br.com.senac.atividade_06_uc15.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroDAO {

    //CadastroDAO Funcionarios:
    public void CadastrarFuncionario(CadastroFuncionario cadastroFuncionario) {
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

    public List<CadastroFuncionario> listarFuncionario(String pesquisarCPF) {
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

    public void excluirFuncionario(int id) {
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

    // CadstroDAO Cliente:
    public void CadastrarCliente(CadastroCliente cadastroCliente) {
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

    public List<CadastroCliente> listarCliente(String pesquisarCPF) {
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

    public void excluirCliente(int id) {
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

    //CadastroDAO produtos:
    public void CadastrarProduto(CadastroProduto cadastroProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cadastroProduto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<CadastroProduto> listarProduto(String pesquisarCodigo) {
        EntityManager em = JPAUtil.getEntityManager();
        List CatalogoProduto = null;
        try {
            String textoQuery = "SELECT p FROM CadastroProduto p WHERE (:codProduto IS NULL OR p.codProduto LIKE :codProduto)";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("codProduto", pesquisarCodigo.isEmpty() ? null : "%" + pesquisarCodigo + "%");

            CatalogoProduto = consulta.getResultList();

        } finally {
            JPAUtil.closeEntityManager();
        }
        return CatalogoProduto;

    }

    public CadastroProduto buscarPorCodigo(String codigoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        CadastroProduto produto = null;

        try {
            String textoQuery = "SELECT p FROM CadastroProduto p WHERE p.codProduto = :codProduto";

            Query consulta = em.createQuery(textoQuery, CadastroProduto.class);
            consulta.setParameter("codProduto", codigoProduto);

            produto = (CadastroProduto) consulta.getSingleResult();

        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } finally {
            em.close();
        }

        return produto;
    }

    public void excluirProduto(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CadastroProduto p = em.find(CadastroProduto.class, id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void AtualizarProduto(CadastroProduto cadastroProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            cadastroProduto = em.merge(cadastroProduto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    // Controle Vendas:
    public void CadastrarVenda(CadastroVendas controleVendas) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(controleVendas);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<CadastroVendas> listarCPFVenda(String pesquisarCPF) {
        EntityManager em = JPAUtil.getEntityManager();
        List<CadastroVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM CadastroVendas v";

            if (!pesquisarCPF.isEmpty()) {
                textoQuery += " WHERE v.cpfNota LIKE :cpfNota";
            }

            Query consulta = em.createQuery(textoQuery, CadastroVendas.class);

            if (!pesquisarCPF.isEmpty()) {
                consulta.setParameter("cpfNota", "%" + pesquisarCPF + "%");
            }

            ListaControleVendas = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return ListaControleVendas;
    }

    public List<CadastroVendas> listarCodigoProdutoVenda(String pesquisarCodigoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        List<CadastroVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM CadastroVendas v";

            if (!pesquisarCodigoProduto.isEmpty()) {
                textoQuery += " WHERE v.codProduto LIKE :codProduto";
            }

            Query consulta = em.createQuery(textoQuery, CadastroVendas.class);

            if (!pesquisarCodigoProduto.isEmpty()) {
                consulta.setParameter("codProduto", "%" + pesquisarCodigoProduto + "%");
            }

            ListaControleVendas = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return ListaControleVendas;
    }

    public List<CadastroVendas> listarIDVenda(String pesquisarID) {
        EntityManager em = JPAUtil.getEntityManager();
        List<CadastroVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM CadastroVendas v";

            if (!pesquisarID.isEmpty()) {
                textoQuery += " WHERE v.idVendedor = :idVendedor";
            }

            Query consulta = em.createQuery(textoQuery, CadastroVendas.class);

            if (!pesquisarID.isEmpty()) {
                int idVendedor = Integer.parseInt(pesquisarID);
                consulta.setParameter("idVendedor", idVendedor);
            }

            ListaControleVendas = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return ListaControleVendas;
    }

}
