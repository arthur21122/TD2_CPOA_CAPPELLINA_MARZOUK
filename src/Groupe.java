package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {

    private List<Etudiant> etudiants;

    private Formation formation;

    public Groupe(Formation f){
        etudiants = new ArrayList<>();
        formation = f;
    }

    public void ajouterEtudiant(Etudiant etudiant){
        if(formation.equals(etudiant.getFormation())){
            etudiants.add(etudiant);
        }
    }

    public void supprimerEtudiant(Etudiant etudiant){
        if(etudiants.contains(etudiant)) {
            etudiants.remove(etudiant);
        }
    }

    public float calculerMoyenneMatiereGroupe(String matiere){
        if(etudiants.size() <= 0) return 0;
        float somme = 0;
        for(Etudiant e : etudiants){
            somme += e.calculMoyenneMatiere(matiere);
        }

        return somme/etudiants.size();
    }

        public float calculerMoyenneGeneraleGroupe(){
        if(etudiants.size() <= 0) return 0;
        float somme = 0;
        for(Etudiant e : etudiants){
            somme += e.calculMoyenneGeneral();
        }

        return somme/etudiants.size();
    }

    public void triAlpha(){
        Collections.sort(etudiants);
    }

    public void triParMerite(){
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return o1.calculMoyenneGeneral() > o2.calculMoyenneGeneral() ? 1 : -1;
            }
        });
    }

}