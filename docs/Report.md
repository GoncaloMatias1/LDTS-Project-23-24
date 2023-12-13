## Space Invaders Project - LDTS 2023/24

Developed by Gonçalo Barroso (up202207832@fe.up.pt), Gonçalo Matias (up202108703@fe.up.pt), and Rodrigo Arteiro (up202108749@fe.up.pt), this project is an engaging reimagining of the classic Space Invaders game. The player maneuvers a laser cannon across the screen's bottom, aiming and firing at overhead aliens. These aliens, arranged in five rows of eleven, shift left and right in unison, moving down each time they reach the screen's edge.

### Implement Features

- **Game Over Screen:** Triggered when aliens reach the bottom or the player loses all lives.
- **Movement Mechanics:** Players can move their character left or right, and aliens will move accordingly.
- **Shooting Mechanism:** Players shoot projectiles using the spacebar, while enemies fire at set intervals.
- **Bullet Collision:** Projectiles will disappear upon hitting an enemy or another bullet, with corresponding damage to the targets.
- **Lives Display:** Player's remaining lives shown in the screen's bottom left corner.

### Design

## Model-View-Controller (MVC) Architecture

The **Model-View-Controller (MVC)** architecture is a design pattern that structures applications into three main components:

- **Model**: The core of the application's business logic, representing the data and the rules that govern access to and updates of this data.
- **View**: The presentation layer that displays the data from the model to the user in a specific format.
- **Controller**: The interface between Model and View, processing all the business logic and incoming requests, manipulating data using the Model, and interacting with the Views to render the final output.

### Advantages of MVC:

- **Separation of Concerns**: Each component has a distinct responsibility, making it easier to manage complexity and maintain the application.
- **Facilitates Parallel Development**: Developers can work on the model, view, and controller code simultaneously, reducing development time.
- **Ease of Modification**: Changes to the business logic or the UI can be made with minimal impact on the other parts of the application.
- **Support for New Types of Views**: Because the model does not depend on the views, new types of views can be added without changing the model.

MVC is particularly well-suited for web applications where the view is the HTML or JSON output returned to the browser. However, it's widely applicable across different types of software development projects.
