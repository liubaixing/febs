package com.febs.monitor.endpoint;

import com.febs.common.annotation.FebsEndPoint;

import java.util.List;

/**
 * @author MrBird
 */
@FebsEndPoint
public class FebsHttpTraceEndpoint {

    /*private final HttpTraceRepository repository;

    public FebsHttpTraceEndpoint(HttpTraceRepository repository) {
        this.repository = repository;
    }

    public FebsHttpTraceDescriptor traces() {
        return new FebsHttpTraceDescriptor(this.repository.findAll());
    }

    public static final class FebsHttpTraceDescriptor {

        private final List<HttpTrace> traces;

        private FebsHttpTraceDescriptor(List<HttpTrace> traces) {
            this.traces = traces;
        }

        public List<HttpTrace> getTraces() {
            return this.traces;
        }
    }*/
}
