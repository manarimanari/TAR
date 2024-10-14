# TAR
projet java
Voici un résumé sans les points :

### Couche Persistance
- Développer les classes entités dans le package **`ma.projet.classes`** (ex. `Projet`, `Tache`, `Employe`).
- Créer le fichier de configuration **`hibernate.cfg.xml`** dans le package **`ma.projet.config`** pour configurer Hibernate.
- Créer la classe **`HibernateUtil`** dans le package **`ma.projet.util`** pour gérer la session Hibernate via **`SessionFactory`**.

### Couche Service
- Créer une interface générique **`IDao`** dans le package **`ma.projet.dao`** pour définir les méthodes CRUD (Create, Read, Update, Delete).
- Créer les classes **`ProjetService`**, **`TacheService`**, **`EmployeService`**, et **`EmployeTacheService`** dans le package **`ma.projet.service`**, chacune implémentant l'interface **`IDao`**.
- Dans la classe **`EmployeService`**, créer des méthodes pour afficher la liste des tâches réalisées par un employé et la liste des projets gérés par un employé.
- Dans la classe **`ProjetService`**, créer des méthodes pour afficher la liste des tâches planifiées pour un projet et la liste des tâches réalisées dans un projet.
- Dans la classe **`TacheService`**, créer une méthode pour afficher les tâches dont le prix est supérieur à 1000 DH avec une requête nommée, et une méthode pour afficher les tâches réalisées entre deux dates.

### Test
- Créer des programmes pour tester les méthodes ci-dessus : afficher les tâches réalisées par un employé, les projets gérés par un employé, les tâches planifiées pour un projet, les tâches réalisées dans un projet, les tâches dont le prix dépasse 1000 DH, et les tâches réalisées entre deux dates.
