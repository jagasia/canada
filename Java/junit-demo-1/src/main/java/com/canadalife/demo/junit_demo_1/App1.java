package com.canadalife.demo.junit_demo_1;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.util.List;

import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;

public class App1 {
	public static void main(String[] args) {
		LauncherDiscoveryRequest req = LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass(MathematicsTest.class)).build();
		Launcher l = LauncherFactory.create();
		SummaryGeneratingListener s = new SummaryGeneratingListener();
		l.registerTestExecutionListeners(s);
		l.execute(req);
		System.out.println(s.getSummary().getTestsFoundCount());
		List<Failure> failures = s.getSummary().getFailures();
		for(Failure failure: failures)
			System.out.println(failure.getException());
	}
}
