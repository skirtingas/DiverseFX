package dev.skir.config.languages

import de.exlll.configlib.Comment
import de.exlll.configlib.Configuration
import de.exlll.configlib.YamlConfigurationProperties
import de.exlll.configlib.YamlConfigurations
import java.io.File
import java.nio.charset.StandardCharsets

@Configuration
class Locale {
    var general: General = General()
    @Configuration
    class General {
        var prefix: String = "<gradient:#6200ff:#00fffb>[Visuals]</gradient>"
        var reloading: String = "%prefix% <green>Reloading plugin..."
        var reloaded: String = "%prefix% <green>Plugin reloaded in %time%ms!"
        var thisVisualIsDisabled: String = "%prefix% <red>This visual is disabled!"
    }
    var shownVisuals: ShownVisuals = ShownVisuals()
    @Configuration
    class ShownVisuals {
        @Comment("""
        Message sent to the player when the visual is shown to another player with/without timings
        %prefix% - Prefix of the plugin
        %target% - Target player
        %text% - Text of the visual
        %fadeIn% - Time in milliseconds for the visual to fade in
        %stay% - Time in milliseconds for the visual to stay
        %fadeOut% - Time in milliseconds for the visual to fade out
        
        Others:
        %title% - Title of the visual
        %subtitle% - Subtitle of the visual
        
        Fullscreen Visual
        """)
        var fullscreen_no_timings: String = "%prefix% <green>Showing fullscreen visual to <u>%target%</u> with text <u>%text%</u>."
        var fullscreen_timings: String = "%prefix% <green>Showing fullscreen visual to <u>%target%</u> with text <u>%text%</u> for <u>%fadeIn%ms %stay%ms %fadeOut%ms</u>."
        @Comment("Transparent Visual")
        var transparent_no_timings: String = "%prefix% <green>Showing transparent visual to <u>%target%</u> with text <u>%text%</u>."
        var transparent_timings: String = "%prefix% <green>Showing transparent visual to <u>%target%</u> with text <u>%text%</u> for <u>%fadeIn%ms %stay%ms %fadeOut%ms</u>."
        @Comment("Freezing Visual")
        var freezing_no_timings: String = "%prefix% <green>Showing freezing visual to <u>%target%</u> with title <u>%title%</u> and subtitle <u>%subtitle%</u>."
        var freezing_timings: String = "%prefix% <green>Showing freezing visual to <u>%target%</u> with title <u>%title%</u> and subtitle <u>%subtitle%</u> for <u>%fadeIn%ms %stay%ms %fadeOut%ms</u>."
        @Comment("Fullscreen Gradient Visual")
        var fullscreen_gradient_no_timings: String = "%prefix% <green>Showing fullscreen gradient visual to <u>%target%</u> with text <gradient:blue:green>%text%</gradient>."
        var fullscreen_gradient_timings: String = "%prefix% <green>Showing fullscreen gradient visual to <u>%target%</u> with text <gradient:blue:green>%text%</gradient> for <u>%fadeIn%ms %stay%ms %fadeOut%ms</u>."
        @Comment("Bottom Gradient Visual")
        var bottom_gradient_no_timings: String = "%prefix% <green>Showing bottom gradient visual to <u>%target%</u> with title <u>%title%</u> and subtitle <u>%subtitle%</u>."
        var bottom_gradient_timings: String = "%prefix% <green>Showing bottom gradient visual to <u>%target%</u> with title <u>%title%</u> and subtitle <u>%subtitle%</u> for <u>%fadeIn%ms %stay%ms %fadeOut%ms</u>."
    }

    companion object {
        private val CONFIG_HEADER = """
            DiverseFX Language File
            
            YOU CAN USE MINIMESSAGE FORMATTING HERE. BUT ONLY MINIMESSAGE FORMATTING.
            """.trimIndent()

        private val PROPERTIES: YamlConfigurationProperties = YamlConfigurationProperties.newBuilder()
            .charset(StandardCharsets.UTF_8)
            .header(CONFIG_HEADER).build()

        fun get(localeCode: String): Locale {
            val file = File(LM.FOLDER, "$localeCode.yml").toPath()
            return YamlConfigurations.load(file, Locale::class.java, PROPERTIES)
        }
    }
}