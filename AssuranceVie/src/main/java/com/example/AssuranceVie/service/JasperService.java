package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.bean.POJO.IAVPFsimpl;
import com.example.AssuranceVie.bean.POJO.SummaryPOJO;
import com.example.AssuranceVie.dao.EtatInscriptionDao;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
@Service
public class JasperService {
    @Autowired
    InscriptionAssuranceVieProduitFinancierDao inscriptionAssuranceVieProduitFinancierDao;
    @Autowired
    InscriptionAssuranceVieDao inscriptionAssuranceVieDao;




    public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Idd(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Id(id);

    }
    public List<SummaryPOJO> findAllforReport(Long ID) {
        SummaryPOJO sump = new SummaryPOJO();
        List<SummaryPOJO> sumpp = new ArrayList<>();
        List<IAVPFsimpl> iavsim = new ArrayList<>();
        InscriptionAssuranceVie ins;
        List<InscriptionAssuranceVieProduitFinancier> INSL = new ArrayList<>();
        INSL = findByIAV_Idd(ID);
        Optional<InscriptionAssuranceVie> inv = inscriptionAssuranceVieDao.findById(ID);
        if (inv.isPresent()) {
            ins = inv.get();
        } else {
            return null;
        }
        for (int i = 0; i < INSL.size(); i++) {
            IAVPFsimpl simp = new IAVPFsimpl();
            simp.setFormule(INSL.get(i).getFormule().getLibelle());
            simp.setDistributeur(INSL.get(i).getDistributeur().getLibelle());
            simp.setEtat(INSL.get(i).getEtatInscription().getLibelle());
            simp.setPolice(INSL.get(i).getPoliceAssurance());
            simp.setMontant(INSL.get(i).getPrix());
            simp.setProduit(INSL.get(i).getProduit().getLibelle());
            iavsim.add(simp);
        }
        sump.setId(ins.getId());
        sump.setCin(ins.getClient().getCin());
        sump.setAdresse(ins.getClient().getAdresse());
        sump.setDateNaissance(ins.getClient().getDateNaissance());
        sump.setNom(ins.getClient().getNom());
        sump.setPrenom(ins.getClient().getPrenom());
        sump.setTelephone(ins.getClient().getTelephone());
        // sump.setProds(iavsim);
        sump.setReference(ins.getReference());
        sumpp.add(sump);

        return sumpp;
    }
    public List<IAVPFsimpl> findAltforReport(Long ID) {
        SummaryPOJO sump = new SummaryPOJO();

        List<IAVPFsimpl> iavsim = new ArrayList<>();
        InscriptionAssuranceVie ins;
        List<InscriptionAssuranceVieProduitFinancier> INSL = new ArrayList<>();
        INSL = findByIAV_Idd(ID);
        Optional<InscriptionAssuranceVie> inv = inscriptionAssuranceVieDao.findById(ID);
        if (inv.isPresent()) {
            ins = inv.get();
        } else {
            return null;
        }
        for (int i = 0; i < INSL.size(); i++) {
            IAVPFsimpl simp = new IAVPFsimpl();
            simp.setFormule(INSL.get(i).getFormule().getLibelle());
            simp.setDistributeur(INSL.get(i).getDistributeur().getLibelle());
            simp.setEtat(INSL.get(i).getEtatInscription().getLibelle());
            simp.setPolice(INSL.get(i).getPoliceAssurance());
            simp.setMontant(INSL.get(i).getPrix());
            simp.setProduit(INSL.get(i).getProduit().getLibelle());
            iavsim.add(simp);
        }


        return iavsim;
    }

    // Method to create the pdf file using the employee list datasource.
    public JasperPrint createPdfReport(Long ID) throws JRException {
        final List<SummaryPOJO> sumry=findAllforReport(ID);
        final List<IAVPFsimpl> prods=findAltforReport(ID);
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/eng.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);


        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("IAVPF",prods);
        parameters.put("IAV",sumry);

        parameters.put("createdBy", "T&A");

        // Filling the report with the engagement data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        // Export the report to a PDF file.

        return print;
    }
}
