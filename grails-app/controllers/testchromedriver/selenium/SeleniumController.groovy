package testchromedriver.selenium

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class SeleniumController {
    SeleniumService seleniumService

    def buscarEnVideo() {
        render (view: 'buscarEnVideo')
    }

    def getVideoData(BuscarEnVideoCommand command) {
        WebDriver driver = seleniumService.inicializarDriver("")
        String searchQuery = command.busqueda.replace(" ", "+")
        String url = "https://www.youtube.com/results?search_query=" + searchQuery

        try {
            driver.get(url)

            // Navegamos hasta el primer video que resulta del query.
            WebElement primerVideo = driver.findElement(By.cssSelector("#contents ytd-video-renderer"))
            WebElement thumbnail = primerVideo.findElement(By.cssSelector("#thumbnail"))
            String urlVideo = thumbnail.getAttribute("href")
            driver.get(urlVideo)
            
            // A partir del url del video de YT obtenemos la información dependiendo de la propiedad "buscarPor" del command.            
            WebElement botonLikes = driver.findElement(By.cssSelector("#top-level-buttons-computed > like-button-view-model > toggle-button-view-model > button"))
            String ariaLabelBotonLikes = botonLikes.getAttribute("aria-label")
            println(ariaLabelBotonLikes)
        } finally {
            // driver.quit()
            redirect(action: "buscarEnVideo")
        }
    }
}