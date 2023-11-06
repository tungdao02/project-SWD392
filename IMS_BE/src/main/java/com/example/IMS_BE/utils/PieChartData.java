package com.example.IMS_BE.utils;

import java.util.List;

public class PieChartData{
        private List<String> labels;
        private List<Long> data;

        public PieChartData(List<String> labels, List<Long> data) {
            this.labels = labels;
            this.data = data;
        }

        public List<String> getLabels() {
            return labels;
        }

        public List<Long> getData() {
            return data;
        }
}
