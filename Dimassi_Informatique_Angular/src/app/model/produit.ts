import { Facture } from "./facture";
import { SousCategorie } from "./sousCategorie";
import { Photos } from "./photos";
import { Commentaire } from "./commentaire";

export interface Produit {
  id: number;
  nom: string;
  description: string;
  prix: number;
  quantite: number;
  sousCategories: SousCategorie[];
  factures: Facture[];
  commentaire: Commentaire[];
}
