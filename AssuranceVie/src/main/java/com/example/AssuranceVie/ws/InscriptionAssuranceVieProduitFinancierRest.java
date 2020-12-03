package com.example.AssuranceVie.ws;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.bean.SummaryPOJO;
import com.example.AssuranceVie.service.InscriptionAssuranceVieService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AssuranceVie.service.InscriptionAssuranceVieProduitFinancierService;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("assurance-api/IAVPF")
public class InscriptionAssuranceVieProduitFinancierRest {

@Autowired
    InscriptionAssuranceVieProduitFinancierService iavfs;
	@GetMapping("find/distID/{distID}")
	List<InscriptionAssuranceVieProduitFinancier> findAllByDistributeur_Id(@PathVariable Long distID){
		return iavfs.findAllByDistributeur_Id(distID);
	}
    @GetMapping("find/produit/{produit}")
    List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(@PathVariable Long produit){
        return iavfs.findByProduit_Id(produit);

    }
    @GetMapping("find/IAV/{IAV}")
    List<InscriptionAssuranceVieProduitFinancier> findByIAV_Id(@PathVariable Long IAV){
        return iavfs.findByIAV_Id(IAV);

    }
    @GetMapping("find/IAV/reference/{reference}")
    List<InscriptionAssuranceVieProduitFinancier> findByReference(@PathVariable String reference){
        return iavfs.findByIAV_Reference(reference);

    }
    @GetMapping("find/all")
    List<InscriptionAssuranceVieProduitFinancier> findAll(){
        return iavfs.findAll();
    }
    @GetMapping("find/ID/{ID}")
    Optional<InscriptionAssuranceVieProduitFinancier> findByID(@PathVariable Long ID){
        return iavfs.findById(ID);

    }
    @PutMapping("update/{id}/{etat}")
    public void updateEtat(@PathVariable Long id,@PathVariable  Long etat) {
		iavfs.updateEtat(id, etat);
	}


    @GetMapping("find/IDP/{IDP}")
    List<SummaryPOJO> findAllForReport(@PathVariable Long IDP){
        return iavfs.findAllforReport(IDP);

    }
    @GetMapping("/report/IDP/{IDP}")
    public void generateReport(HttpServletResponse response, @PathVariable Long IDP) throws JRException, IOException {
response.setContentType("application/x-download");
response.setHeader("Content-Disposition",String.format("attachement; filename=\"EngagementCli.pdf\""));
        OutputStream out=response.getOutputStream();
       iavfs.createPdfReport(IDP,out);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable Long id) {
        iavfs.deleteById(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody InscriptionAssuranceVieProduitFinancier insvie) {
        return iavfs.save(insvie);
    }
    @DeleteMapping("/delete/iav/{id}")
	public void deleteByiAV_Id(Long id) {
		iavfs.deleteByiAV_Id(id);
	}
	@GetMapping("find/{id}")
	public Optional<InscriptionAssuranceVieProduitFinancier> findById(Long id) {
		return iavfs.findById(id);
	}

}
