import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";

import { ProfileComponent } from "./examples/profile/profile.component";
import { ProduitListComponent } from "./pages/produit-liste/produit-liste.component";
import { ProduitComponent } from "./pages/produit/produit.component";

const routes: Routes = [
  { path: "", redirectTo: "listeProduit", pathMatch: "full" },
  { path: "listeProduit", component: ProduitListComponent },
  { path: "profile", component: ProfileComponent },
  { path: "produit/:id", component: ProduitComponent },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true,
    }),
  ],
  exports: [],
})
export class AppRoutingModule {}
