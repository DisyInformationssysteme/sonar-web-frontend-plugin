package fr.sii.sonar.web.client.html.quality;

import org.sonar.api.rules.RuleFinder;

import fr.sii.sonar.report.core.quality.profile.JsonProfileParser;
import fr.sii.sonar.report.core.quality.profile.ProfileFileDefinition;

/**
 * Just a specific implementation to help dependency injection
 * 
 * @author Aurélien Baudet
 *
 */
public class HtmlHintProfileDefinition extends ProfileFileDefinition {

	public HtmlHintProfileDefinition(RuleFinder ruleFinder, HtmlHintQualityConstants constants) {
		super(HtmlHintProfileDefinition.class.getResourceAsStream(constants.getProfileJsonPath()), new JsonProfileParser(), ruleFinder);
	}

}
