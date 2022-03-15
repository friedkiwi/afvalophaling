package gent.gouvernementstraat.afvalophaling.models;

public enum Ophaling {
    PAPIER {
        public String toString() {
            return "Papier";
        }
    },
    GLAS {
        public String toString() {
            return "Glas";
        }
    },
    REST {
        public String toString() {
            return "Restafval";
        }
    }
}
