package br.com.fiap.bo;

import br.com.fiap.dao.FornecimentoDAO;
import br.com.fiap.to.FornecimentoTO;
import jakarta.validation.Valid;

import java.util.List;

public class FornecimentoBO {

        public List<FornecimentoTO> findAll() {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.findAll();
        }

        public List<FornecimentoTO> findByUsuarioId(Long usuarioId) {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.findByUsuarioId(usuarioId);
        }

        public FornecimentoTO findById(Long idFornecimento) {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.findById(idFornecimento);
        }

        public FornecimentoTO update(@Valid FornecimentoTO fornecimento) {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.update(fornecimento);
        }

        public boolean delete(Long idFornecimento) {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.delete(idFornecimento);
        }

        public FornecimentoTO save(@Valid FornecimentoTO fornecimento) {
            FornecimentoDAO fornecimentoDAO = new FornecimentoDAO();
            return fornecimentoDAO.save(fornecimento);
        }
}
