import { Adresse } from "./adresse";

export interface Visiteur {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  password: string;
  photo: string;
  adresse: Adresse;
}
