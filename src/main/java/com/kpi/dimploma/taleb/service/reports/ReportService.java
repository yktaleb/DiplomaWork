package com.kpi.dimploma.taleb.service.reports;

import com.kpi.dimploma.taleb.model.Report;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Report> getReports();
    GeneratedReport generateReport(Long id, Map<Integer, String> parameters);
    XlsWorkbook generateXlsReport(Long id, Map<Integer, String> parameters);
}
