package fr.sii.sonar.web.frontend.ng.eslint;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.SonarPlugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import fr.sii.sonar.report.core.common.PluginDependencies;
import fr.sii.sonar.web.frontend.ng.eslint.quality.EslintAngularProfileDefinition;
import fr.sii.sonar.web.frontend.ng.eslint.quality.EslintAngularQualityConstants;
import fr.sii.sonar.web.frontend.ng.eslint.quality.EslintAngularQualitySensor;
import fr.sii.sonar.web.frontend.ng.eslint.quality.EslintAngularRulesDefinition;

/**
 * This class is the entry point for all extensions
 */
public final class EslintAngularPlugin extends SonarPlugin {


	// This is where you're going to declare all your Sonar extensions
	@SuppressWarnings({ "rawtypes" })
	public List getExtensions() {
		return Arrays.asList(
				// needed here for standalone version
				PluginDependencies.class,
				
	            // Quality configuration
				PropertyDefinition.builder(EslintAngularQualityConstants.REPORT_PATH_KEY)
		            .defaultValue(EslintAngularQualityConstants.REPORT_PATH_DEFVALUE)
		            .category(EslintAngularQualityConstants.CATEGORY)
		            .subCategory(EslintAngularQualityConstants.SUB_CATEGORY)
		            .name("Angular Hint report path")
		            .description("The path to the Angular Hint report file to load")
		            .onQualifiers(Qualifiers.PROJECT)
		            .build(),
				PropertyDefinition.builder(EslintAngularQualityConstants.FAIL_MISSING_FILE_KEY)
		            .defaultValue(EslintAngularQualityConstants.FAIL_MISSING_FILE_DEFVALUE)
		            .category(EslintAngularQualityConstants.CATEGORY)
		            .subCategory(EslintAngularQualityConstants.SUB_CATEGORY)
		            .name("Fail on missing source file")
		            .description("True to stop analysis if a source file is not found")
		            .onQualifiers(Qualifiers.PROJECT)
		            .build(),
				PropertyDefinition.builder(EslintAngularQualityConstants.SKIP_FILE_METRICS_KEY)
		            .defaultValue(EslintAngularQualityConstants.SKIP_FILE_METRICS_DEFVALUE)
		            .category(EslintAngularQualityConstants.CATEGORY)
		            .subCategory(EslintAngularQualityConstants.SUB_CATEGORY)
		            .name("Skip save of file metrics")
		            .description("If you have several plugins that are able to handle JavaScript, you may have an error (Can not add the same measure twice). Set it to true to let the other plugin save the metrics")
		            .onQualifiers(Qualifiers.PROJECT)
		            .build(),

				EslintAngularQualityConstants.class,
				EslintAngularRulesDefinition.class,
				EslintAngularProfileDefinition.class,
				EslintAngularQualitySensor.class
		);
	}
}
