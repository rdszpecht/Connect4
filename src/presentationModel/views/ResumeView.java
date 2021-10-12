package presentationModel.views;

import presentationModel.controllers.*;

public class ResumeView {

    private ResumeController resumeController;

    public ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    boolean interact() {
        return this.resumeController.isResumed();
    }
}
