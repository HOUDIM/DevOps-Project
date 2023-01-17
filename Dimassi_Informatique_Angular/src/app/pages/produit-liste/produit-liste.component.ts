import { Component, OnInit } from "@angular/core";
import { SousCategorie } from "app/model/sousCategorie";
import { Produit } from "app/model/produit";
import { SousCategorieService } from "app/service/sousCategorie.service";
import { ProduitService } from "app/service/produit.service";

@Component({
  selector: "produit-liste",
  templateUrl: "./produit-liste.component.html",
  styleUrls: ["./produit-liste.component.css"],
})
export class ProduitListComponent implements OnInit {
  produits!: Produit[];
  constructor(
    private service: ProduitService,
    private serviceSousCategorie: SousCategorieService
  ) {}
  sousCategorie!: SousCategorie[];
  page = 4;
  page1 = 5;
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
  fill() {
    this.sousCategorie.forEach((cat) => {
      return this.dropdownList.push({ id: cat.id, itemName: cat.nom });
    });
  }
  ngOnInit() {
    this.service.getAllProduits().subscribe((data) => {
      this.produits = data;
      console.log(this.produits)
    });
    this.serviceSousCategorie.getAllSousCategories().subscribe((data) => {
      this.sousCategorie = data;
      if (this.sousCategorie) {
        this.fill();
      }
    });
    this.selectedItems = [];
    this.dropdownSettings = {
      singleSelection: false,
      text: "Select SousCategories...",
      selectAllText: "Select All",
      unSelectAllText: "UnSelect All",
      enableSearchFilter: true,
      classes: "c-btn,selected-list,ng-star-inserted",
    };
  }
  ngOnChanges() {}
  ngDoCheck() {
    if (this.dropdownList.length == 0) {
      this.fill();
    }
  }
  onItemSelect(item: any) {
    console.log(item);
    console.log(this.selectedItems);
  }
  OnItemDeSelect(item: any) {
    console.log(item);
    console.log(this.selectedItems);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
  onDeSelectAll(items: any) {
    console.log(items);
  }
}
