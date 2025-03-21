package br.com.senac.atividade_04_uc15.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

public class CatalogoProdutoDAO {

    public void Cadastrar(CatalogoProduto catalogoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(catalogoProduto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<CatalogoProduto> listar(String pesquisarCodigo) {
        EntityManager em = JPAUtil.getEntityManager();
        List CatalogoProduto = null;
        try {
            String textoQuery = "SELECT p FROM CatalogoProduto p WHERE (:codProduto IS NULL OR p.codProduto LIKE :codProduto)";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("codProduto", pesquisarCodigo.isEmpty() ? null : "%" + pesquisarCodigo + "%");

            CatalogoProduto = consulta.getResultList();

        } finally {
            JPAUtil.closeEntityManager();
        }
        return CatalogoProduto;

    }

    public CatalogoProduto buscarPorCodigo(String codigoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        CatalogoProduto produto = null;

        try {
            String textoQuery = "SELECT p FROM CatalogoProduto p WHERE p.codProduto = :codProduto";

            Query consulta = em.createQuery(textoQuery, CatalogoProduto.class);
            consulta.setParameter("codProduto", codigoProduto);

            produto = (CatalogoProduto) consulta.getSingleResult();

        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } finally {
            em.close();
        }

        return produto;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CatalogoProduto p = em.find(CatalogoProduto.class, id);
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

    public void Atualizar(CatalogoProduto catalogoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            catalogoProduto = em.merge(catalogoProduto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}
