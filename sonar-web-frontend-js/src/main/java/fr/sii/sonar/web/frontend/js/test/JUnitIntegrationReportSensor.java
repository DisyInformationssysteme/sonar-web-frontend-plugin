package fr.sii.sonar.web.frontend.js.test;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.config.Settings;
import org.sonar.api.rules.RuleFinder;

import fr.sii.sonar.report.core.common.ReportSensor;
import fr.sii.sonar.report.core.test.domain.TestReport;
import fr.sii.sonar.report.core.test.factory.TestSaverFactory;
import fr.sii.sonar.report.test.junit.factory.JUnitFallbackProviderFactory;

/**
 * Sensor specialized to load JUnit report file and save integration test measures
 * 
 * @author Aurélien Baudet
 *
 */
public class JUnitIntegrationReportSensor extends ReportSensor<TestReport> {

	public JUnitIntegrationReportSensor(JUnitIntegrationConstants constants, Settings settings, RuleFinder ruleFinder, FileSystem filesystem, ResourcePerspectives resourcePerspective) {
		super(constants, settings, ruleFinder, filesystem, resourcePerspective, new JUnitFallbackProviderFactory(), new TestSaverFactory());
	}

}
