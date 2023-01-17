import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Photos } from "app/model/photos";
import { Produit } from "app/model/produit";
import { Commentaire } from "app/model/commentaire";
import { CommentaireService } from "app/service/commentaire.service";
import { ProduitService } from "app/service/produit.service";

@Component({
  selector: "produit",
  templateUrl: "./produit.component.html",
  styleUrls: ["./produit.component.css"],
})
export class ProduitComponent implements OnInit {
  constructor(
    private ar: ActivatedRoute,
    private service: ProduitService,
    private serviceCommentaire: CommentaireService,
    private router: Router
  ) {}
  produit!: Produit;
  commentaires!: Commentaire[];
  photos!: Photos;
  page = 1;
  id = parseInt(localStorage.getItem("id"));
  ngOnInit() {
    let id = this.ar.snapshot.params["id"];
    this.service.getProduit(id).subscribe((data) => {
      this.produit = data;
    });
    this.service.getProduitPhoto(id).subscribe((data) => {
      this.photos = data;
      console.log(this.photos);
    });
    this.serviceCommentaire.getAllCommentaire(id).subscribe((data) => {
      this.commentaires = data;
      console.log(this.commentaires);
    });
  }

  onSubmit(f: NgForm) {
    let fd = new FormData();
    fd.append(
      "commentaire",
      JSON.stringify({
        texte: f.value.texte,
        visiteur: { id: this.id },
        produit: { id: this.produit.id },
      })
    );
    this.serviceCommentaire.add(fd).subscribe(() => {
      window.location.reload();
    });
  }
}
