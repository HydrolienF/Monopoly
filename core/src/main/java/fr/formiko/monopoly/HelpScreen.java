package fr.formiko.monopoly;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/** First screen of the application. Displayed after the application is created. */
public class HelpScreen implements Screen {
    private Stage stg;
    private Monopoly game;

    private Skin skin  = new Skin(Gdx.files.internal("ui/uiskin.json"));

    public HelpScreen(Monopoly monopoly) {
        this.game = monopoly;

    }

    @Override
    public void show() {
        this.stg = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stg);
        Table table = new Table();
        table.setFillParent(true);
        stg.addActor(table);


        // Title
        Label titleLabel = new Label("Help", skin);
        table.add(titleLabel).pad(10);
        table.row();

        // Scrollable Text Area for Monopoly Rules
        String monopolyRules = "Monopoly Rules Here..."; // Replace this with actual Monopoly rules
        Label rulesLabel = new Label(monopolyRules, skin);
        rulesLabel.setWrap(true);
        ScrollPane scrollPane = new ScrollPane(rulesLabel, skin);
        table.add(scrollPane).expand().fill().pad(10).height(Gdx.graphics.getHeight() * 0.9f);
        table.row();

        // Back Button
        TextButton backButton = new TextButton("Back", skin);
        backButton.pad(10);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("CLICKED BACK BTN");
                game.setScreen(new MainMenuScreen(game)); // Change to your actual main menu screen
            }

            ;
        });
        table.add(backButton).pad(10);

        table.top(); // Align content to the top of th


    }

    @Override
    public void render(float delta) {
        handleInput();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(143/256f, 188/256f, 114/256f,1);
        stg.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stg.draw();
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){

        }
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
        stg.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
