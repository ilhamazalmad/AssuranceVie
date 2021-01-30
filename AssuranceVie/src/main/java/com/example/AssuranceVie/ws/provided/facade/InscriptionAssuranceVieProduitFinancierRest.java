package com.example.AssuranceVie.ws.provided.facade;

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.service.facade.InscriptionAssuranceVieProduitFinancierService;
import com.example.AssuranceVie.service.util.JasperService;
import com.example.AssuranceVie.ws.provided.converter.ClientConverter;
import com.example.AssuranceVie.ws.provided.converter.DistributeurConverter;
import com.example.AssuranceVie.ws.provided.converter.EtatConverter;
import com.example.AssuranceVie.ws.provided.converter.FormuleConverter;
import com.example.AssuranceVie.ws.provided.converter.IAVConverter;
import com.example.AssuranceVie.ws.provided.converter.IAVPFConverter;
import com.example.AssuranceVie.ws.provided.converter.ProduitConverter;
import com.example.AssuranceVie.ws.provided.dto.InscriptionAssuranceVieProduitFinancierDto;
import com.example.AssuranceVie.ws.provided.dto.SummaryPOJO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("assurance-api/IAVPF")
@CrossOrigin(origins="http://localhost:4200")

public class InscriptionAssuranceVieProduitFinancierRest {

	@Autowired
    InscriptionAssuranceVieProduitFinancierService iavfs;
    @Autowired
    JasperService jpserv;
    @Autowired
    IAVPFConverter iAVPFConverter;
    @Autowired
    IAVConverter iAVConverter;
    @Autowired
    ClientConverter clientConverter;
    @Autowired
    DistributeurConverter distributeurConverter;
    @Autowired
    EtatConverter etatConverter ;
    @Autowired
    FormuleConverter formuleConverter;
    @Autowired
    ProduitConverter produitConverter;
    
	@GetMapping("find/distID/{distID}")
	List<InscriptionAssuranceVieProduitFinancierDto> findAllByDistributeur_Id(@PathVariable Long distID){
		return iAVPFConverter.toVo(iavfs.findAllByDistributeur_Id(distID));
	}
	@GetMapping("find/dist/{id}")
	List<InscriptionAssuranceVieProduitFinancierDto> findAllForDistributeur(@PathVariable Long id){
		iAVPFConverter.setDistributeur(false);
		iAVPFConverter.setEtatInscription(true);
		iAVPFConverter.setFormule(true);
		iAVPFConverter.setiAV(true);
		iAVPFConverter.setProduit(true);
		etatConverter.setiAVPF(false);
		formuleConverter.setProduit(false);
		iAVConverter.setiAVPF(false);
		iAVConverter.setClient(true);
		clientConverter.setiAV(false);
		produitConverter.setFormules(false);
		produitConverter.setiAVPF(false);
		return iAVPFConverter.toVo(iavfs.findAllForDistributeur(id));
	}
    @GetMapping("find/produit/{produit}")
    List<InscriptionAssuranceVieProduitFinancierDto> findByProduit_Id(@PathVariable Long produit){
        return iAVPFConverter.toVo(iavfs.findByProduit_Id(produit));

    }
    @GetMapping("find/IAV/{IAV}")
    List<InscriptionAssuranceVieProduitFinancierDto> findByIAV_Id(@PathVariable Long IAV){
    	
        return iAVPFConverter.toVo(iavfs.findByIAV_Id(IAV));

    }
    @GetMapping("find/etat/{id}")
    List<InscriptionAssuranceVieProduitFinancierDto> findByEtatInscription(@PathVariable Long id){
    	iAVPFConverter.setDistributeur(true);
		iAVPFConverter.setEtatInscription(true);
		iAVPFConverter.setFormule(true);
		iAVPFConverter.setiAV(true);
		iAVPFConverter.setProduit(true);
		etatConverter.setiAVPF(false);
		formuleConverter.setProduit(false);
		iAVConverter.setiAVPF(false);
		iAVConverter.setClient(false);
		clientConverter.setiAV(false);
		produitConverter.setFormules(false);
		produitConverter.setiAVPF(false);
        return iAVPFConverter.toVo(iavfs.findByEtatInscription(id));

    }
    
    @GetMapping("find/all")
    List<InscriptionAssuranceVieProduitFinancierDto> findAll(){
    	iAVPFConverter.setDistributeur(true);
		iAVPFConverter.setEtatInscription(true);
		iAVPFConverter.setFormule(true);
		iAVPFConverter.setiAV(true);
		iAVPFConverter.setProduit(true);
		etatConverter.setiAVPF(false);
		formuleConverter.setProduit(false);
		iAVConverter.setiAVPF(false);
		iAVConverter.setClient(true);
		clientConverter.setiAV(false);
		produitConverter.setFormules(false);
		produitConverter.setiAVPF(false);
		distributeurConverter.setiAVPF(false);
        return iAVPFConverter.toVo(iavfs.findAll());
    }
    @GetMapping("find/ID/{ID}")
    InscriptionAssuranceVieProduitFinancierDto findByID(@PathVariable Long ID){
        return iAVPFConverter.toVo(iavfs.findById(ID));

    }
    @PutMapping("update/{id}/{etat}")
    public void updateEtat(@PathVariable Long id,@PathVariable  Long etat) {
		iavfs.updateEtat(id, etat);
	}


    @GetMapping("find/IDP/{IDP}")
    List<SummaryPOJO> findAllForReport(@PathVariable Long IDP){
        return jpserv.findAllforReport(IDP);

    }
    @GetMapping("/report/IDP/{IDP}")
    public void generateReport(HttpServletResponse response, @PathVariable Long IDP) throws JRException, IOException {
    response.setContentType("application/x-download");
    response.setHeader("Content-Disposition",String.format("attachement; filename=\"EngagementCli.pdf\""));
        OutputStream out=response.getOutputStream();
        JasperPrint print=jpserv.createPdfReport(IDP);
        JasperExportManager.exportReportToPdfStream(print, out);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable Long id) {
        iavfs.deleteById(id);
    }




    @PostMapping("/save")
    public int save(@RequestBody InscriptionAssuranceVieProduitFinancierDto insvie) {
        return iavfs.save(iAVPFConverter.toBean(insvie));
    }
    @DeleteMapping("/delete/iav/{id}")
	public void deleteByiAV_Id(@PathVariable Long id) {
		iavfs.deleteByiAV_Id(id);
	}
    
    @PutMapping("affilier/{id}/{dist_id}")
	public void affilier(@PathVariable Long id, @PathVariable Long dist_id) {
		iavfs.affilier(id, dist_id);
	}
	@GetMapping("find/{id}")
	public InscriptionAssuranceVieProduitFinancierDto findById(@PathVariable Long id) {
		return iAVPFConverter.toVo(iavfs.findById(id));
	}

}
