package br.com.senac.atividade_04_uc15.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ControleVendasDAO {

    public void Cadastrar(ControleVendas controleVendas) {
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

    public List<ControleVendas> listarCPF(String pesquisarCPF) {
        EntityManager em = JPAUtil.getEntityManager();
        List<ControleVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM ControleVendas v";

            if (!pesquisarCPF.isEmpty()) {
                textoQuery += " WHERE v.cpfNota LIKE :cpfNota";
            }

            Query consulta = em.createQuery(textoQuery, ControleVendas.class);

            if (!pesquisarCPF.isEmpty()) {
                consulta.setParameter("cpfNota", "%" + pesquisarCPF + "%");
            }

            ListaControleVendas = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return ListaControleVendas;
    }

    public List<ControleVendas> listarCodigoProduto(String pesquisarCodigoProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        List<ControleVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM ControleVendas v";

            if (!pesquisarCodigoProduto.isEmpty()) {
                textoQuery += " WHERE v.codProduto LIKE :codProduto";
            }

            Query consulta = em.createQuery(textoQuery, ControleVendas.class);

            if (!pesquisarCodigoProduto.isEmpty()) {
                consulta.setParameter("codProduto", "%" + pesquisarCodigoProduto + "%");
            }

            ListaControleVendas = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return ListaControleVendas;
    }

    public List<ControleVendas> listarID(String pesquisarID) {
        EntityManager em = JPAUtil.getEntityManager();
        List<ControleVendas> ListaControleVendas = null;
        try {
            String textoQuery = "SELECT v FROM ControleVendas v";

            
            if (!pesquisarID.isEmpty()) {
                textoQuery += " WHERE v.idVendedor = :idVendedor";
            }

            Query consulta = em.createQuery(textoQuery, ControleVendas.class);

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
