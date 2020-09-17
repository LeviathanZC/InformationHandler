package by.zercomp.application.controller.command;

import by.zercomp.application.entity.impl.Text;

public class Request {

    private Text data;
    private Object param;

    public Request(Text text, Object param) {
        this.data = text;
        this.param = param;
    }

    public Text getData () {
        return data;
    }

    public Object getParam() {
        return param;
    }

}
