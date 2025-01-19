# eService - Managementul unui Service Auto

## Descriere
eService este o aplicație concepută pentru a gestiona activitățile unui service auto. Aceasta permite gestionarea clienților, vehiculelor, mecanicilor, pieselor auto și reparațiilor. Aplicația este destinată atât personalului administrativ, cât și mecanicilor pentru a facilita activitatea zilnică a unui service auto.

---

## Cerințe de Business

1. **Gestionarea clienților**:
   - Permite adăugarea, modificarea, ștergerea și listarea informațiilor despre clienți (nume, telefon, email).

2. **Gestionarea vehiculelor**:
   - Oferă posibilitatea de a înregistra vehiculele clienților cu detalii precum marcă, model, tip combustibil, kilometraj și putere motor.

3. **Gestionarea mecanicilor**:
   - Administrează informațiile despre mecanici (nume, salariu) și permite calcularea profitului lunar generat de fiecare mecanic.

4. **Gestionarea pieselor**:
   - Asigură înregistrarea pieselor auto, inclusiv numele piesei, producătorul, costul și stocul disponibil.

5. **Gestionarea reparațiilor**:
   - Permite înregistrarea reparațiilor efectuate, asocierea reparațiilor cu mecanici, vehicule și clienți, precum și adăugarea pieselor utilizate.

6. **Raportarea profitului**:
   - Calculează profitul total generat de un mecanic într-o anumită lună.

7. **Căutare vehicule**:
   - Permite căutarea vehiculelor după marcă.

8. **Listarea pieselor utilizate pentru o reparație**:
   - Oferă detalii despre piesele utilizate pentru o anumită reparație.

9. **Integrarea cu Swagger**:
   - Documentarea completă a API-ului pentru a facilita utilizarea și testarea acestuia.

10. **Persistența datelor**:
    - Toate informațiile sunt stocate într-o bază de date relațională (SQL Server).

---

## Funcționalități principale pentru MVP (Minimum Viable Product)

### 1. **Gestionarea clienților**
   - Utilizatorii pot crea, edita, șterge și vizualiza informațiile despre clienți.
   - Fiecare client are următoarele câmpuri: ID, nume, telefon și email.

### 2. **Gestionarea vehiculelor**
   - Utilizatorii pot înregistra vehiculele clienților, căuta vehicule după marcă și șterge vehicule.
   - Fiecare vehicul include: ID, număr de înmatriculare, marcă, model, tip combustibil, kilometraj și putere motor.

### 3. **Gestionarea mecanicilor**
   - Aplicația permite adăugarea și ștergerea mecanicilor, precum și calcularea profitului generat lunar de un mecanic.
   - Informațiile stocate despre un mecanic sunt: ID, nume și salariu.

### 4. **Gestionarea reparațiilor**
   - Utilizatorii pot adăuga reparații, șterge reparații și vizualiza lista completă a reparațiilor.
   - Se pot asocia piese auto unei reparații și se poate lista toate piesele utilizate pentru o anumită reparație.

### 5. **Documentare și testare API cu Swagger**
   - Aplicația include documentare automată a API-ului prin intermediul Swagger, oferind acces rapid la toate endpoint-urile disponibile și exemple de utilizare.

---

## Structura Repository-ului

1. **Cod sursă:**
   - Aplicația este scrisă în Java, utilizând Spring Boot pentru logica aplicației și Spring Data pentru persistență.

2. **Testare:**
   - Unit tests sunt incluse pentru a valida funcționalitățile principale (de ex., calcularea profitului mecanicilor, căutarea vehiculelor după marcă).

3. **Documentație API:**
   - Integrare cu Swagger pentru a oferi o interfață vizuală a endpoint-urilor disponibile.

