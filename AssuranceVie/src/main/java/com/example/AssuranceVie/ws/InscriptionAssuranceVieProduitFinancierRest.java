package com.example.AssuranceVie.ws;

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.service.InscriptionAssuranceVieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AssuranceVie.service.InscriptionAssuranceVieProduitFinancierService;

import javax.websocket.server.PathParam;
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
	@GetMapping("find/dist/{id}")
	List<InscriptionAssuranceVieProduitFinancier> findAllForDistributeur(@PathVariable Long id){
		return iavfs.findAllByDistributeur_Id(id);
	}
    @GetMapping("find/produit/{produit}")
    List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(@PathVariable Long produit){
        return iavfs.findByProduit_Id(produit);

    }
    @GetMapping("find/IAV/{IAV}")
    List<InscriptionAssuranceVieProduitFinancier> findByIAV_Id(@PathVariable Long IAV){
        return iavfs.findByIAV_Id(IAV);

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
	@DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable Long id) {
        iavfs.deleteById(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody InscriptionAssuranceVieProduitFinancier insvie) {
        return iavfs.save(insvie);
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
	public Optional<InscriptionAssuranceVieProduitFinancier> findById(@PathVariable Long id) {
		return iavfs.findById(id);
	}

    
}
