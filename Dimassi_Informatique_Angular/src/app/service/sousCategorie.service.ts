import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { SousCategorie } from "app/model/sousCategorie";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class SousCategorieService {
  host = "http://localhost:8081/api/sousCategorie";
  constructor(private client: HttpClient) {}

  public getAllSousCategories(): Observable<SousCategorie[]> {
    return this.client.get<SousCategorie[]>(this.host + "/all");
  }
}
