# Projet de Modélisation Objet

## Présentation

Ce projet constitue une simulation complète d'une application de gestion de stages, conçue selon une approche de modélisation orientée objet. Il est réalisé dans un contexte pédagogique visant à mettre en pratique les principes fondamentaux de la conception objet, notamment l'héritage, le polymorphisme, l'encapsulation, et la modélisation UML.

## Objectifs pédagogiques

* Mettre en œuvre les concepts de la programmation orientée objet (POO)
* Modéliser un système réel à l'aide de diagrammes UML
* Implémenter une application en Java à partir de diagrammes de conception
* Rédiger un rapport technique justifiant les choix de conception

## Fonctionnalités implémentées

* Gestion des étudiants, tuteurs universitaires et tuteurs en entreprise
* Suivi de fiches de faisabilité et de comptes-rendus de visites
* Attribution des rôles et gestion des acteurs

## Architecture du projet

```
Modelisation objet/
├── Main.java                   # Point d'entrée de l'application
├── Etudiant.java               # Classe représentant un étudiant
├── Personne.java               # Classe mère générique
├── TuteurEntreprise.java       # Spécialisation de Personne
├── TuteurUniversitaire.java    # Spécialisation de Personne
├── CompteRendu.java            # Gestion des comptes-rendus de visites
├── FicheFaisabilite.java       # Gestion des fiches de faisabilité
├── ListeRole.java              # Gestion centralisée des rôles
├── Role.java                   # Définition des rôles utilisateurs
├── Visite.java                 # Entité de visite de stage
├── RapportMO.pdf.pdf           # Rapport de projet complet
├── Diagramme MO/               # Dossier contenant tous les diagrammes UML
│   ├── Diagramme de classe
│   ├── Diagrammes de cas d'utilisation
│   ├── Diagrammes de séquence
│   ├── Diagramme d'activité
│   └── Diagramme d'état
```

## Diagrammes UML inclus

* **Diagramme de classe général** : Représentation structurelle des entités
* **Diagrammes de cas d'utilisation** : Scénarios fonctionnels du système
* **Diagrammes de séquence** : Chronologie des interactions entre objets
* **Diagramme d'activité** : Représentation du flux de contrôle
* **Diagramme d'état** : Évolution des objets dans le temps

## Compilation et exécution

Assurez-vous d'avoir un environnement Java configuré (JDK 8+).

Compilation :

```bash
javac *.java
```

Exécution :

```bash
java Main
```

## Auteurs

* Nom(s) à compléter (prévoir ici les étudiants responsables)

## Rapport

Le document `RapportMO.pdf.pdf` contient la justification des choix de conception, les tests réalisés, ainsi qu'une réflexion sur les difficultés rencontrées et les perspectives d'amélioration.

## Auteur
[KECHIR Amine](https://github.com/amn-kchr)

---

> Ce travail constitue un excellent exercice de synthèse entre modélisation théorique (UML) et application concrète (Java), illustrant la portée de la modélisation objet dans la résolution de problèmes concrets.
