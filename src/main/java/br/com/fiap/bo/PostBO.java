package br.com.fiap.bo;

import br.com.fiap.dao.PostDAO;
import br.com.fiap.to.PostTO;
import jakarta.validation.Valid;

import java.util.List;

public class PostBO {
    public PostTO save(@Valid PostTO post) {
        PostDAO postDAO = new PostDAO();
        return postDAO.save(post);
    }

    public PostTO update(@Valid PostTO post) {
        PostDAO postDAO = new PostDAO();
        return postDAO.update(post);
    }

    public boolean delete(Long idPost) {
        PostDAO postDAO = new PostDAO();
        return postDAO.delete(idPost);
    }

    public List<PostTO> findAll() {
        PostDAO postDAO = new PostDAO();
        return postDAO.findAll();
    }

    public PostTO findById(Long idPost) {
        PostDAO postDAO = new PostDAO();
        return postDAO.findById(idPost);
    }

    public List<PostTO> findByUsuarioId(Long usuarioId) {
        PostDAO postDAO = new PostDAO();
        return postDAO.findByUsuarioId(usuarioId);
    }
}
