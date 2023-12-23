package com.goncalomatias1.l05gr06.View.Game;

import com.goncalomatias1.l05gr06.Model.Game.EntityModel;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EntityViewTest {

    @Test
    void draw_callsDrawWithMockedGraphics() {
        EntityModel mockModel = mock(EntityModel.class);
        TextGraphics mockGraphics = mock(TextGraphics.class);

        EntityView entityView = new EntityView(mockModel) {
            @Override
            public void draw(TextGraphics graphics) {
                graphics.putString(0, 0, "Test");
            }
        };

        entityView.draw(mockGraphics);

        verify(mockGraphics).putString(0, 0, "Test");
    }
}
