package presentationModel.views;

import presentationModel.controllers.PlayController;
import presentationModel.controllers.ResumeController;
import presentationModel.controllers.StartController;

public class View {
    private StartController startController;
    private ResumeController resumeController;
    private PlayController playController;
    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(StartController startController, ResumeController resumeController, PlayController playController) {
        this.startController = startController;
        this.resumeController = resumeController;
        this.playController = playController;

        this.startView = new StartView(this.startController);
        this.playView = new PlayView(this.playController);
        this.resumeView = new ResumeView(this.resumeController);
    }

    public void start(){
        this.startView.interact();
    }

    public void play(){
        this.playView.interact();
    }

    public boolean resume(){
        return this.resumeView.interact();
    }

}
