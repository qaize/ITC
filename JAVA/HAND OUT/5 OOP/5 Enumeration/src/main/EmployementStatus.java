package main;

public enum EmployementStatus {

    APP("Applicant"),
    CAN("Candidate"){
        @Override
        public boolean isEmployee(){
            return true;
        }
    },
    PER("Permanent"){
        @Override
        public boolean isEmployee(){
            return true;
        }
    },
    CON("Contract"){
        @Override
        public boolean isEmployee(){
            return true;
        }
    },
    CAS("Casual"){
        @Override
        public boolean isEmployee(){
            return true;
        }
    },
    PAR("Part Time"){
        @Override
        public boolean isEmployee(){
            return true;
        }
    };

    private String label;

    EmployementStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isEmployee(){
        return false;
    }
}
