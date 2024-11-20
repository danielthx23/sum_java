package br.com.fiap.bo;

import br.com.fiap.dao.CertificadoDAO;
import br.com.fiap.to.CertificadoTO;
import jakarta.validation.Valid;

import java.util.List;

public class CertificadoBO {
    public CertificadoTO save(@Valid CertificadoTO certificado) {
        CertificadoDAO certificadoDAO = new CertificadoDAO();
        return certificadoDAO.save(certificado);
    }

    public boolean delete(Long idCertificado) {
        CertificadoDAO certificadoDAO = new CertificadoDAO();
        return certificadoDAO.delete(idCertificado);
    }

    public List<CertificadoTO> getByUsuarioId(Long usuarioId) {
        CertificadoDAO certificadoDAO = new CertificadoDAO();
        return certificadoDAO.findByUsuarioId(usuarioId);
    }
}
