package fr.sii.sonar.web.client.js;

import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.config.Settings;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.scan.filesystem.ModuleFileSystem;

import fr.sii.sonar.quality.core.QualitySensor;
import fr.sii.sonar.quality.core.factory.QualityProviderFactory;
import fr.sii.sonar.quality.core.factory.QualitySaverFactory;

/**
 * Just a specific implementation to help dependency injection
 * 
 * @author Aurélien Baudet
 *
 */
public class JsQualitySensor extends QualitySensor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsQualitySensor(JsQualityConstants constants, Settings settings, RuleFinder ruleFinder, ModuleFileSystem filesystem, ResourcePerspectives resourcePerspective,
			JsQualityReportProviderFactory providerFactory, JsQualityReportSaverFactory saverFactory) {
		super(constants, settings, ruleFinder, filesystem, resourcePerspective, (QualityProviderFactory) providerFactory, (QualitySaverFactory) saverFactory);
	}

}
