package com.cognifide.cogboard.config

import com.cognifide.cogboard.CogboardConstants
import com.cognifide.cogboard.config.strategy.Config
import com.cognifide.cogboard.config.strategy.ConfigFactory
import io.vertx.core.json.JsonObject
import java.io.File

class ConfigLoader(private val configType: ConfigType){

    private var config: Config = ConfigFactory.resolveStrategy(configType)

    fun loadConfig(): JsonObject {
        val conf = File(config.filePath()).readText()
        val configJson = JsonObject(conf)
        return if (config.validate(configJson)) configJson
        else CogboardConstants.errorResponse("$configType config not valid")
    }
}