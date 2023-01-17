import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Produit } from "app/model/produit";
import { Observable } from "rxjs";
import { Photos } from "app/model/photos";

@Injectable({
  providedIn: "root",
})
export class ProduitService {
  host = "http://localhost:8081/api/produit";
  
  constructor(private client: HttpClient) {}

  public getAllProduits(): Observable<Produit[]> {
    return this.client.get<Produit[]>(this.host + "/all");
  }

  public getProduit(id: number): Observable<Produit> {
    return this.client.get<Produit>(this.host + "/one/" + id);
  }

  public getProduitPhoto(id: number): Observable<Photos> {
    return this.client.get<Photos>(this.host + "/photo/" + id);
  }
}
