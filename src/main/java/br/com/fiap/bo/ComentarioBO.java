package br.com.fiap.bo;

import br.com.fiap.dao.ComentarioDAO;
import br.com.fiap.to.ComentarioTO;
import jakarta.validation.Valid;

import java.util.List;

public class ComentarioBO {
    public ComentarioTO save(@Valid ComentarioTO comentario) {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        return comentarioDAO.save(comentario);
    }

    public ComentarioTO update(@Valid ComentarioTO comentario) {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        return comentarioDAO.update(comentario);
    }

    public boolean delete(Long idComentario) {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        return comentarioDAO.delete(idComentario);
    }

    public List<ComentarioTO> findByUsuarioId(Long usuarioId) {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        return comentarioDAO.findByUsuarioId(usuarioId);
    }

    public List<ComentarioTO> findByPostId(Long postId) {
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        return comentarioDAO.findByPostId(postId);
    }

}
