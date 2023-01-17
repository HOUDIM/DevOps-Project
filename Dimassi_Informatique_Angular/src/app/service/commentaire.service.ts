import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Commentaire } from "app/model/commentaire";

@Injectable({
  providedIn: "root",
})
export class CommentaireService {
  host = "http://localhost:8081/api/commentaire";
  constructor(private client: HttpClient) {}

  public getAllCommentaire(id: number): Observable<Commentaire[]> {
    return this.client.get<Commentaire[]>(this.host + "/allByProduit/" + id);
  }

  public add(fd: FormData): Observable<Commentaire> {
    return this.client.post<Commentaire>(this.host + "/add", fd);
  }
}
