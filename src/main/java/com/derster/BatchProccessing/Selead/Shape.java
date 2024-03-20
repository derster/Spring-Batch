package com.derster.BatchProccessing.Selead;

public sealed interface Shape permits Circle, Square, Triangle {

    // Méthode pour calculer l'aire de la forme
    double area();
}
