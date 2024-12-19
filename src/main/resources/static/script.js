function toggleInfo(id) {
    const info = document.getElementById(id);
    info.classList.toggle('hidden');
}
document.addEventListener("DOMContentLoaded", () => {
    const startButton = document.getElementById("startButton");
    const welcomeScreen = document.getElementById("welcomeScreen");
    const islandScreen = document.getElementById("containerScreen");

    startButton.addEventListener("click", () => {
        console.log("Cambiando pantallas...");
        console.log("Antes del cambio:", {
            welcomeScreenClasses: welcomeScreen.className,
            islandScreenClasses: islandScreen.className,
        });

        welcomeScreen.classList.add("hidden");
        islandScreen.classList.remove("hidden");

        console.log("Después del cambio:", {
            welcomeScreenClasses: welcomeScreen.className,
            islandScreenClasses: islandScreen.className,
        });
    });
});