/*
 * Copyright (c) 2012, JFXtras
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *       * Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *       * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *       * Neither the name of the <organization> nor the
 *         names of its contributors may be used to endorse or promote products
 *         derived from this software without specific prior written permission.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 *   DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package jfxtras.labs.scene.control.gauge;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.List;


/**
 * Created by
 * User: hansolo
 * Date: 05.03.12
 * Time: 10:03
 */
public class GaugeBuilder<T extends Gauge> {
    // ******************** Variable definitions ******************************
    private HashMap<String, Property> gaugeProperties = new HashMap<String, Property>();
    private HashMap<String, Property> styleProperties = new HashMap<String, Property>();


    // ******************** Enum definitions **********************************
    public enum GaugeType {
        LCD,
        LINEAR,
        RADIAL_HALF_N,
        RADIAL_HALF_S,
        RADIAL_QUARTER_N,
        RADIAL_QUARTER_E,
        RADIAL_QUARTER_S,
        RADIAL_QUARTER_W,
        RADIAL
    }


    // ******************** Methods *******************************************
    public static final GaugeBuilder create() {
        return new GaugeBuilder();
    }

    public final Gauge build() {
        Gauge      gauge;
        GaugeType  gaugeType  = GaugeType.RADIAL;
        GaugeModel gaugeModel = new GaugeModel();
        StyleModel styleModel = new StyleModel();
        double     prefWidth  = -1;
        double     prefHeight = -1;

        // gauge model
        for (String key : gaugeProperties.keySet()) {
            if ("gaugeType".equals(key)) {
                gaugeType = ((ObjectProperty<GaugeType>) gaugeProperties.get(key)).get();
            } else if ("value".equals(key)) {
                gaugeModel.setValue(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("valueAnimationEnabled".equals(key)) {
                gaugeModel.setValueAnimationEnabled(((BooleanProperty) gaugeProperties.get(key)).get());
            } else if ("animationDuration".equals(key)) {
                gaugeModel.setAnimationDuration(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("minValue".equals(key)) {
                gaugeModel.setMinValue(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("maxValue".equals(key)) {
                gaugeModel.setMaxValue(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("threshold".equals(key)) {
                gaugeModel.setThreshold(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("thresholdBehaviorInverted".equals(key)) {
                gaugeModel.setThresholdBehaviorInverted(((BooleanProperty) gaugeProperties.get(key)).get());
            } else if ("title".equals(key)) {
                gaugeModel.setTitle(((StringProperty) gaugeProperties.get(key)).get());
            } else if ("unit".equals(key)) {
                gaugeModel.setUnit(((StringProperty) gaugeProperties.get(key)).get());
            } else if ("lcdValueCoupled".equals(key)) {
                gaugeModel.setLcdValueCoupled(((BooleanProperty) gaugeProperties.get(key)).get());
            } else if ("lcdThreshold".equals(key)) {
                gaugeModel.setLcdThreshold(((DoubleProperty) gaugeProperties.get(key)).get());
            } else if ("lcdThresholdBehaviorInverted".equals(key)) {
                gaugeModel.setLcdThresholdBehaviorInverted(((BooleanProperty) gaugeProperties.get(key)).get());
            } else if ("lcdUnitString".equals(key)) {
                gaugeModel.setLcdUnit(((StringProperty) gaugeProperties.get(key)).get());
            } else if ("lcdNumberSystem".equals(key)) {
                gaugeModel.setLcdNumberSystem(((ObjectProperty<Gauge.NumberSystem>) gaugeProperties.get(key)).get());
            } else if ("maxNoOfMajorTicks".equals(key)) {
                gaugeModel.setMaxNoOfMajorTicks(((IntegerProperty) gaugeProperties.get(key)).get());
            } else if ("maxNoOfMinorTicks".equals(key)) {
                gaugeModel.setMaxNoOfMinorTicks(((IntegerProperty) gaugeProperties.get(key)).get());
            } else if ("majorTickSpacing".equals(key)) {
                gaugeModel.setMajorTickSpacing(((IntegerProperty) gaugeProperties.get(key)).get());
            } else if ("minorTickSpacing".equals(key)) {
                gaugeModel.setMinorTickSpacing(((IntegerProperty) gaugeProperties.get(key)).get());
            } else if ("trend".equals(key)) {
                gaugeModel.setTrend(((ObjectProperty<Gauge.Trend>) gaugeProperties.get(key)).get());
            } else if ("niceScaling".equals(key)) {
                gaugeModel.setNiceScaling(((BooleanProperty) gaugeProperties.get(key)).get());
            } else if ("sectionsArray".equals(key)) {
                gaugeModel.setSections(((ObjectProperty<Section[]>) gaugeProperties.get(key)).get());
            } else if ("sectionsList".equals(key)) {
                gaugeModel.setSections(((ObjectProperty<List<Section>>) gaugeProperties.get(key)).get());
            } else if ("areasArray".equals(key)) {
                gaugeModel.setAreas(((ObjectProperty<Section[]>) gaugeProperties.get(key)).get());
            } else if ("areasList".equals(key)) {
                gaugeModel.setAreas(((ObjectProperty<List<Section>>) gaugeProperties.get(key)).get());
            } else if ("tickMarkSectionsArray".equals(key)) {
                gaugeModel.setTickMarkSections(((ObjectProperty<Section[]>) gaugeProperties.get(key)).get());
            } else if ("tickMarkSectionsList".equals(key)) {
                gaugeModel.setTickMarkSections(((ObjectProperty<List<Section>>) gaugeProperties.get(key)).get());
            } else if ("markersArray".equals(key)) {
                gaugeModel.setMarkers(((ObjectProperty<Marker[]>) gaugeProperties.get(key)).get());
            } else if ("markersList".equals(key)) {
                gaugeModel.setMarkers(((ObjectProperty<List<Marker>>) gaugeProperties.get(key)).get());
            } else if ("prefWidth".equals(key)) {
                prefWidth = ((DoubleProperty) gaugeProperties.get(key)).get();
            } else if ("prefHeight".equals(key)) {
                prefHeight = ((DoubleProperty) gaugeProperties.get(key)).get();
            }
        }

        // style model
        for(String key : styleProperties.keySet()) {
            if ("bargraph".equals(key)) {
                styleModel.setBargraph(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("minMeasuredValueVisible".equals(key)) {
                styleModel.setMinMeasuredValueVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("maxMeasuredValueVisible".equals(key)) {
                styleModel.setMaxMeasuredValueVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("thresholdVisible".equals(key)) {
                styleModel.setThresholdVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("thresholdColor".equals(key)) {
                styleModel.setThresholdColor(((ObjectProperty<Gauge.ThresholdColor>) styleProperties.get(key)).get());
            } else if ("frameDesign".equals(key)) {
                styleModel.setFrameDesign(((ObjectProperty<Gauge.FrameDesign>) styleProperties.get(key)).get());
            } else if ("frameVisible".equals(key)) {
                styleModel.setFrameVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("backgroundDesign".equals(key)) {
                styleModel.setBackgroundDesign(((ObjectProperty<Gauge.BackgroundDesign>) styleProperties.get(key)).get());
            } else if ("backgroundVisible".equals(key)) {
                styleModel.setBackgroundVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("knobDesign".equals(key)) {
                styleModel.setKnobDesign(((ObjectProperty<Gauge.KnobDesign>) styleProperties.get(key)).get());
            } else if ("knobColor".equals(key)) {
                styleModel.setKnobColor(((ObjectProperty<Gauge.KnobColor>) styleProperties.get(key)).get());
            } else if ("postsVisible".equals(key)) {
                styleModel.setPostsVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("pointerType".equals(key)) {
                styleModel.setPointerType(((ObjectProperty<Gauge.PointerType>) styleProperties.get(key)).get());
            } else if ("valueColor".equals(key)) {
                styleModel.setValueColor(((ObjectProperty<ColorDef>) styleProperties.get(key)).get());
            } else if ("pointerGlowEnabled".equals(key)) {
                styleModel.setPointerGlowEnabled(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("pointerShadowEnabled".equals(key)) {
                styleModel.setPointerShadowEnabled(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("ledVisible".equals(key)) {
                styleModel.setLedVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("ledColor".equals(key)) {
                styleModel.setLedColor(((ObjectProperty<LedColor>) styleProperties.get(key)).get());
            } else if ("userLedVisible".equals(key)) {
                styleModel.setUserLedVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("userLedColor".equals(key)) {
                styleModel.setUserLedColor(((ObjectProperty<LedColor>) styleProperties.get(key)).get());
            } else if ("userLedOn".equals(key)) {
                styleModel.setUserLedOn(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("userLedBlinking".equals(key)) {
                styleModel.setUserLedBlinking(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("titleFont".equals(key)) {
                styleModel.setTitleFont(((StringProperty) styleProperties.get(key)).get());
            } else if ("unitFont".equals(key)) {
                styleModel.setUnitFont(((StringProperty) styleProperties.get(key)).get());
            } else if ("foregroundType".equals(key)) {
                styleModel.setForegroundType(((ObjectProperty<Radial.ForegroundType>) styleProperties.get(key)).get());
            } else if ("foregroundVisible".equals(key)) {
                styleModel.setForegroundVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("lcdThresholdVisible".equals(key)) {
                styleModel.setLcdThresholdVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("lcdDesign".equals(key)) {
                styleModel.setLcdDesign(((ObjectProperty<LcdDesign>) styleProperties.get(key)).get());
            } else if ("lcdVisible".equals(key)) {
                styleModel.setLcdVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("lcdUnitStringVisible".equals(key)) {
                styleModel.setLcdUnitVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("lcdNumberSystemVisible".equals(key)) {
                styleModel.setLcdNumberSystemVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("lcdUnitFont".equals(key)) {
                styleModel.setLcdUnitFont(((StringProperty) styleProperties.get(key)).get());
            } else if ("lcdTitleFont".equals(key)) {
                styleModel.setLcdTitleFont(((StringProperty) styleProperties.get(key)).get());
            } else if ("lcdValueFont".equals(key)) {
                styleModel.setLcdValueFont(((ObjectProperty<Gauge.LcdFont>) styleProperties.get(key)).get());
            } else if ("lcdDecimals".equals(key)) {
                styleModel.setLcdDecimals(((IntegerProperty) styleProperties.get(key)).get());
            } else if ("lcdBlinking".equals(key)) {
                styleModel.setLcdBlinking(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("glowVisible".equals(key)) {
                styleModel.setGlowVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("glowOn".equals(key)) {
                styleModel.setGlowOn(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("tickmarksVisible".equals(key)) {
                styleModel.setTickmarksVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("majorTickmarksVisible".equals(key)) {
                styleModel.setMajorTicksVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("majorTickmarkType".equals(key)) {
                styleModel.setMajorTickmarkType(((ObjectProperty<Gauge.TickmarkType>) styleProperties.get(key)).get());
            } else if ("majorTickmarkColor".equals(key)) {
                styleModel.setMajorTickmarkColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("minorTickmarksVisible".equals(key)) {
                styleModel.setMinorTicksVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("minorTickmarkColor".equals(key)) {
                styleModel.setMinorTickmarkColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("tickLabelsVisible".equals(key)) {
                styleModel.setTickLabelsVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("tickLabelOrientation".equals(key)) {
                styleModel.setTickLabelOrientation(((ObjectProperty<Gauge.TicklabelOrientation>) styleProperties.get(key)).get());
            } else if ("tickmarkGlowEnabled".equals(key)) {
                styleModel.setTickmarkGlowEnabled(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("tickmarkGlowColor".equals(key)) {
                styleModel.setTickmarkGlowColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("sectionsVisible".equals(key)) {
                styleModel.setSectionsVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("sectionsHighlighting".equals(key)) {
                styleModel.setSectionsHighlighting(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("showSectionTickmarksOnly".equals(key)) {
                styleModel.setShowSectionTickmarksOnly(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("areasVisible".equals(key)) {
                styleModel.setAreasVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("areasHighlighting".equals(key)) {
                styleModel.setAreasHighlighting(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("markersVisible".equals(key)) {
                styleModel.setMarkersVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("textureColor".equals(key)) {
                styleModel.setTextureColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("simpleGradientBaseColor".equals(key)) {
                styleModel.setSimpleGradientBaseColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("titleVisible".equals(key)) {
                styleModel.setTitleVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("unitVisible".equals(key)) {
                styleModel.setUnitVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("trendVisible".equals(key)) {
                styleModel.setTrendVisible(((BooleanProperty) styleProperties.get(key)).get());
            } else if ("trendUpColor".equals(key)) {
                styleModel.setTrendUpColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("trendSteadyColor".equals(key)) {
                styleModel.setTrendSteadyColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            } else if ("trendDownColor".equals(key)) {
                styleModel.setTrendDownColor(((ObjectProperty<Color>) styleProperties.get(key)).get());
            }
        }

        switch (gaugeType) {
            case LCD:
                gauge = (T) new Lcd(gaugeModel, styleModel);
            case LINEAR:
                gauge = new Linear(gaugeModel, styleModel);
            case RADIAL_HALF_N:
                gauge = (T) new RadialHalfN(gaugeModel, styleModel);
            case RADIAL_HALF_S:
                gauge = (T) new RadialHalfS(gaugeModel, styleModel);
            case RADIAL_QUARTER_N:
                gauge = (T) new RadialQuarterN(gaugeModel, styleModel);
            case RADIAL_QUARTER_E:
                gauge = (T) new RadialQuarterE(gaugeModel, styleModel);
            case RADIAL_QUARTER_S:
                gauge = (T) new RadialQuarterS(gaugeModel, styleModel);
            case RADIAL_QUARTER_W:
                gauge = (T) new RadialQuarterW(gaugeModel, styleModel);
            case RADIAL:
            default:
                gauge = (T) new Radial(gaugeModel, styleModel);
        }
        if (prefWidth != -1) {
            gauge.setPrefWidth(prefWidth);
        }
        if (prefHeight != -1) {
            gauge.setPrefHeight(prefHeight);
        }
        return gauge;
    }


    // ******************** GaugeModel related ********************************
    public final GaugeBuilder gaugeType(final GaugeType GAUGE_TYPE) {
        gaugeProperties.put("gaugeType", new SimpleObjectProperty<GaugeType>(GAUGE_TYPE));
        return this;
    }

    public final GaugeBuilder value(final double VALUE) {
        gaugeProperties.put("value", new SimpleDoubleProperty(VALUE));
        return this;
    }

    public final GaugeBuilder valueAnimationEnabled(final boolean VALUE_ANIMATION_ENABLED) {
        gaugeProperties.put("valueAnimationEnabled", new SimpleBooleanProperty(VALUE_ANIMATION_ENABLED));
        return this;
    }

    public final GaugeBuilder animationDuration(final double ANIMATION_DURATION) {
        gaugeProperties.put("animationDuration", new SimpleDoubleProperty(ANIMATION_DURATION));
        return this;
    }

    public final GaugeBuilder minValue(final double MIN_VALUE) {
        gaugeProperties.put("minValue", new SimpleDoubleProperty(MIN_VALUE));
        return this;
    }

    public final GaugeBuilder maxValue(final double MAX_VALUE) {
        gaugeProperties.put("maxValue", new SimpleDoubleProperty(MAX_VALUE));
        return this;
    }

    public final GaugeBuilder threshold(final double THRESHOLD) {
        gaugeProperties.put("threshold", new SimpleDoubleProperty(THRESHOLD));
        return this;
    }

    public final GaugeBuilder thresholdBehaviorInverted(final boolean THRESHOLD_BEHAVIOR_INVERTED) {
        gaugeProperties.put("thresholdBehaviorInverted", new SimpleBooleanProperty(THRESHOLD_BEHAVIOR_INVERTED));
        return this;
    }

    public final GaugeBuilder title(final String TITLE) {
        gaugeProperties.put("title", new SimpleStringProperty(TITLE));
        return this;
    }

    public final GaugeBuilder unit(final String UNIT) {
        gaugeProperties.put("unit", new SimpleStringProperty(UNIT));
        return this;
    }

    public final GaugeBuilder lcdValueCoupled(final boolean LCD_VALUE_COUPLED) {
        gaugeProperties.put("lcdValueCoupled", new SimpleBooleanProperty(LCD_VALUE_COUPLED));
        return this;
    }

    public final GaugeBuilder lcdThreshold(final double LCD_THRESHOLD) {
        gaugeProperties.put("lcdThreshold", new SimpleDoubleProperty(LCD_THRESHOLD));
        return this;
    }

    public final GaugeBuilder lcdThresholdBehaviorInverted(final boolean LCD_THRESHOLD_BEHAVIOR_INVERTED) {
        gaugeProperties.put("lcdThresholdBehaviorInverted", new SimpleBooleanProperty(LCD_THRESHOLD_BEHAVIOR_INVERTED));
        return this;
    }

    public final GaugeBuilder lcdUnitString(final String LCD_UNIT_STRING) {
        gaugeProperties.put("lcdUnitString", new SimpleStringProperty(LCD_UNIT_STRING));
        return this;
    }

    public final GaugeBuilder lcdNumberSystem(final Gauge.NumberSystem LCD_NUMBER_SYSTEM) {
        gaugeProperties.put("lcdNumberSystem", new SimpleObjectProperty<Gauge.NumberSystem>(LCD_NUMBER_SYSTEM));
        return this;
    }

    public final GaugeBuilder maxNoOfMajorTicks(final int MAX_NO_OF_MAJOR_TICKS) {
        gaugeProperties.put("maxNoOfMajorTicks", new SimpleIntegerProperty(MAX_NO_OF_MAJOR_TICKS));
        return this;
    }

    public final GaugeBuilder maxNoOfMinorTicks(final int MAX_NO_OF_MINOR_TICKS) {
        gaugeProperties.put("maxNoOfMinorTicks", new SimpleIntegerProperty(MAX_NO_OF_MINOR_TICKS));
        return this;
    }

    public final GaugeBuilder majorTickSpacing(final int MAJOR_TICKSPACING) {
        gaugeProperties.put("majorTickSpacing", new SimpleIntegerProperty(MAJOR_TICKSPACING));
        return this;
    }

    public final GaugeBuilder minorTickSpacing(final int MINOR_TICKSPACING) {
        gaugeProperties.put("minorTickSpacing", new SimpleIntegerProperty(MINOR_TICKSPACING));
        return this;
    }

    public final GaugeBuilder trend(final Gauge.Trend TREND) {
        gaugeProperties.put("trend", new SimpleObjectProperty<Gauge.Trend>(TREND));
        return this;
    }

    public final GaugeBuilder niceScaling(final boolean NICE_SCALING) {
        gaugeProperties.put("niceScaling", new SimpleBooleanProperty(NICE_SCALING));
        return this;
    }

    public final GaugeBuilder sections(final Section... SECTION_ARRAY) {
        gaugeProperties.put("sectionsArray", new SimpleObjectProperty<Section[]>(SECTION_ARRAY));
        return this;
    }

    public final GaugeBuilder sections(final List<Section> SECTIONS) {
        gaugeProperties.put("sectionsList", new SimpleObjectProperty<List<Section>>(SECTIONS));
        return this;
    }

    public final GaugeBuilder areas(final Section... AREAS_ARRAY) {
        gaugeProperties.put("areasArray", new SimpleObjectProperty<Section[]>(AREAS_ARRAY));
        return this;
    }

    public final GaugeBuilder areas(final List<Section> AREAS) {
        gaugeProperties.put("areasList", new SimpleObjectProperty<List<Section>>(AREAS));
        return this;
    }

    public final GaugeBuilder markers(final Marker... MARKER_ARRAY) {
        gaugeProperties.put("markersArray", new SimpleObjectProperty<Marker[]>(MARKER_ARRAY));
        return this;
    }

    public final GaugeBuilder markers(final List<Marker> MARKERS) {
        gaugeProperties.put("markersList", new SimpleObjectProperty<List<Marker>>(MARKERS));
        return this;
    }

    public final GaugeBuilder prefWidth(final double WIDTH) {
        gaugeProperties.put("prefWidth", new SimpleDoubleProperty(WIDTH));
        return this;
    }

    public final GaugeBuilder prefHeight(final double HEIGHT) {
        gaugeProperties.put("prefHeight", new SimpleDoubleProperty(HEIGHT));
        return this;
    }



    // ******************** StyleModel related ********************************
    public final GaugeBuilder bargraph(final boolean BARGRAPH) {
        styleProperties.put("bargraph", new SimpleBooleanProperty(BARGRAPH));
        return this;
    }

    public final GaugeBuilder minMeasuredValueVisible(final boolean MIN_MEASURED_VALUE_VISIBLE) {
        styleProperties.put("minMeasuredValueVisible", new SimpleBooleanProperty(MIN_MEASURED_VALUE_VISIBLE));
        return this;
    }

    public final GaugeBuilder maxMeasuredValueVisible(final boolean MAX_MEASURED_VALUE_VISIBLE) {
        styleProperties.put("maxMeasuredValueVisible", new SimpleBooleanProperty(MAX_MEASURED_VALUE_VISIBLE));
        return this;
    }

    public final GaugeBuilder thresholdVisible(final boolean THRESHOLD_VISIBLE) {
        styleProperties.put("thresholdVisible", new SimpleBooleanProperty(THRESHOLD_VISIBLE));
        return this;
    }

    public final GaugeBuilder thresholdColor(final Gauge.ThresholdColor THRESHOLD_COLOR) {
        styleProperties.put("thresholdColor", new SimpleObjectProperty<Gauge.ThresholdColor>(THRESHOLD_COLOR));
        return this;
    }

    public final GaugeBuilder frameDesign(final Gauge.FrameDesign FRAME_DESIGN) {
        styleProperties.put("frameDesign", new SimpleObjectProperty<Gauge.FrameDesign>(FRAME_DESIGN));
        return this;
    }

    public final GaugeBuilder frameVisible(final boolean FRAME_VISIBLE) {
        styleProperties.put("frameVisible", new SimpleBooleanProperty(FRAME_VISIBLE));
        return this;
    }

    public final GaugeBuilder backgroundDesign(final Gauge.BackgroundDesign BACKGROUND_DESIGN) {
        styleProperties.put("backgroundDesign", new SimpleObjectProperty<Gauge.BackgroundDesign>(BACKGROUND_DESIGN));
        return this;
    }

    public final GaugeBuilder backgroundVisible(final boolean BACKGROUND_VISIBLE) {
        styleProperties.put("backgroundVisible", new SimpleBooleanProperty(BACKGROUND_VISIBLE));
        return this;
    }

    public final GaugeBuilder knobDesign(final Gauge.KnobDesign KNOB_DESIGN) {
        styleProperties.put("knobDesign", new SimpleObjectProperty<Gauge.KnobDesign>(KNOB_DESIGN));
        return this;
    }

    public final GaugeBuilder knobColor(final Gauge.KnobColor KNOB_COLOR) {
        styleProperties.put("knobColor", new SimpleObjectProperty<Gauge.KnobColor>(KNOB_COLOR));
        return this;
    }

    public final GaugeBuilder postsVisible(final boolean POSTS_VISIBLE) {
        styleProperties.put("postsVisible", new SimpleBooleanProperty(POSTS_VISIBLE));
        return this;
    }

    public final GaugeBuilder pointerType(final Gauge.PointerType POINTER_TYPE) {
        styleProperties.put("pointerType", new SimpleObjectProperty<Gauge.PointerType>(POINTER_TYPE));
        return this;
    }

    public final GaugeBuilder valueColor(final ColorDef VALUE_COLOR) {
        styleProperties.put("valueColor", new SimpleObjectProperty<ColorDef>(VALUE_COLOR));
        return this;
    }

    public final GaugeBuilder pointerGlowEnabled(final boolean POINTER_GLOW_ENABLED) {
        styleProperties.put("pointerGlowEnabled", new SimpleBooleanProperty(POINTER_GLOW_ENABLED));
        return this;
    }

    public final GaugeBuilder pointerShadowEnabled(final boolean POINTER_SHADOW_ENABLED) {
        styleProperties.put("pointerShadowEnabled", new SimpleBooleanProperty(POINTER_SHADOW_ENABLED));
        return this;
    }

    public final GaugeBuilder ledVisible(final boolean LED_VISIBLE) {
        styleProperties.put("ledVisible", new SimpleBooleanProperty(LED_VISIBLE));
        return this;
    }

    public final GaugeBuilder ledColor(final LedColor LED_COLOR) {
        styleProperties.put("ledColor", new SimpleObjectProperty<LedColor>(LED_COLOR));
        return this;
    }

    public final GaugeBuilder userLedVisible(final boolean USER_LED_VISIBLE) {
        styleProperties.put("userLedVisible", new SimpleBooleanProperty(USER_LED_VISIBLE));
        return this;
    }

    public final GaugeBuilder userLedColor(final LedColor USER_LED_COLOR) {
        styleProperties.put("userLedColor", new SimpleObjectProperty<LedColor>(USER_LED_COLOR));
        return this;
    }

    public final GaugeBuilder userLedOn(final boolean USER_LED_ON) {
        styleProperties.put("userLedOn", new SimpleBooleanProperty(USER_LED_ON));
        return this;
    }

    public final GaugeBuilder userLedBlinking(final boolean USER_LED_BLINKING) {
        styleProperties.put("userLedBlinking", new SimpleBooleanProperty(USER_LED_BLINKING));
        return this;
    }

    public final GaugeBuilder titleFont(final String TITLE_FONT) {
        styleProperties.put("titleFont", new SimpleStringProperty(TITLE_FONT));
        return this;
    }

    public final GaugeBuilder unitfont(final String UNIT_FONT) {
        styleProperties.put("unitFont", new SimpleStringProperty(UNIT_FONT));
        return this;
    }

    public final GaugeBuilder foregroundType(final Radial.ForegroundType FOREGROUND_TYPE) {
        styleProperties.put("foregroundType", new SimpleObjectProperty<Radial.ForegroundType>(FOREGROUND_TYPE));
        return this;
    }

    public final GaugeBuilder foregroundVisible(final boolean FOREGROUND_VISIBLE) {
        styleProperties.put("foregroundVisible", new SimpleBooleanProperty(FOREGROUND_VISIBLE));
        return this;
    }

    public final GaugeBuilder lcdThresholdVisible(final boolean LCD_THRESHOLD_VISIBLE) {
        styleProperties.put("lcdThresholdVisible", new SimpleBooleanProperty(LCD_THRESHOLD_VISIBLE));
        return this;
    }

    public final GaugeBuilder lcdDesign(final LcdDesign LCD_Design) {
        styleProperties.put("lcdDesign", new SimpleObjectProperty<LcdDesign>(LCD_Design));
        return this;
    }

    public final GaugeBuilder lcdVisible(final boolean LCD_VISIBLE) {
        styleProperties.put("lcdVisible", new SimpleBooleanProperty(LCD_VISIBLE));
        return this;
    }

    public final GaugeBuilder lcdUnitStringVisible(final boolean LCD_UNIT_STRING_VISIBLE) {
        styleProperties.put("lcdUnitStringVisible", new SimpleBooleanProperty(LCD_UNIT_STRING_VISIBLE));
        return this;
    }

    public final GaugeBuilder lcdNumberSystemVisible(final boolean NUMBER_SYSTEM_VISIBLE) {
        styleProperties.put("lcdNumberSystemVisible", new SimpleBooleanProperty(NUMBER_SYSTEM_VISIBLE));
        return this;
    }

    public final GaugeBuilder lcdUnitFont(final String UNIT_FONT) {
        styleProperties.put("lcdUnitFont", new SimpleStringProperty(UNIT_FONT));
        return this;
    }

    public final GaugeBuilder lcdTitleFont(final String TITLE_FONT) {
        styleProperties.put("lcdTitleFont", new SimpleStringProperty(TITLE_FONT));
        return this;
    }

    public final GaugeBuilder lcdValueFont(final Gauge.LcdFont VALUE_FONT) {
        styleProperties.put("lcdValueFont", new SimpleObjectProperty<Gauge.LcdFont>(VALUE_FONT));
        return this;
    }

    public final GaugeBuilder lcdDecimals(final int LCD_DECIMALS) {
        styleProperties.put("lcdDecimals", new SimpleIntegerProperty(LCD_DECIMALS));
        return this;
    }

    public final GaugeBuilder lcdBlinking(final boolean LCD_BLINKING) {
        styleProperties.put("lcdBlinking", new SimpleBooleanProperty(LCD_BLINKING));
        return this;
    }

    public final GaugeBuilder glowVisible(final boolean GLOW_VISIBLE) {
        styleProperties.put("glowVisible", new SimpleBooleanProperty(GLOW_VISIBLE));
        return this;
    }

    public final GaugeBuilder glowOn(final boolean GLOW_ON) {
        styleProperties.put("glowOn", new SimpleBooleanProperty(GLOW_ON));
        return this;
    }

    public final GaugeBuilder pulsatingGlow(final boolean PULSATING_GLOW) {
        styleProperties.put("pulsatingGlow", new SimpleBooleanProperty(PULSATING_GLOW));
        return this;
    }

    public final GaugeBuilder glowColor(final Color GLOW_COLOR) {
        styleProperties.put("glowColor", new SimpleObjectProperty<Color>(GLOW_COLOR));
        return this;
    }

    public final GaugeBuilder tickmarksVisible(final boolean TICKMARKS_VISIBLE) {
        styleProperties.put("tickmarksVisible", new SimpleBooleanProperty(TICKMARKS_VISIBLE));
        return this;
    }

    public final GaugeBuilder majorTickmarksVisible(final boolean MAJOR_TICKMARKS_VISIBLE) {
        styleProperties.put("majorTickmarksVisible", new SimpleBooleanProperty(MAJOR_TICKMARKS_VISIBLE));
        return this;
    }

    public final GaugeBuilder majorTickmarkType(final Gauge.TickmarkType TICKMARK_TYPE) {
        styleProperties.put("majorTickmarkType", new SimpleObjectProperty<Gauge.TickmarkType>(TICKMARK_TYPE));
        return this;
    }

    public final GaugeBuilder majorTickmarkColor(final Color MAJOR_TICKMAKR_COLOR) {
        styleProperties.put("majorTickmarkColor", new SimpleObjectProperty<Color>(MAJOR_TICKMAKR_COLOR));
        return this;
    }

    public final GaugeBuilder minorTickmarksVisible(final boolean MINOR_TICKMARKS_VISIBLE) {
        styleProperties.put("minorTickmarksVisible", new SimpleBooleanProperty(MINOR_TICKMARKS_VISIBLE));
        return this;
    }

    public final GaugeBuilder minorTickmarkColor(final Color MINOR_TICKMARK_COLOR) {
        styleProperties.put("minorTickmarkColor", new SimpleObjectProperty<Color>(MINOR_TICKMARK_COLOR));
        return this;
    }

    public final GaugeBuilder tickLabelsVisible(final boolean TICKLABELS_VISIBLE) {
        styleProperties.put("tickLablesVisible", new SimpleBooleanProperty(TICKLABELS_VISIBLE));
        return this;
    }

    public final GaugeBuilder tickLabelOrientation(final Gauge.TicklabelOrientation TICKLABEL_ORIENTATION) {
        styleProperties.put("tickLabelOrientation", new SimpleObjectProperty<Gauge.TicklabelOrientation>(TICKLABEL_ORIENTATION));
        return this;
    }

    public final GaugeBuilder tickLabelNumberFormat(final Gauge.NumberFormat TICKLABEL_NUMBER_FORMAT) {
        styleProperties.put("tickLabelNumberFormat", new SimpleObjectProperty<Gauge.NumberFormat>(TICKLABEL_NUMBER_FORMAT));
        return this;
    }

    public final GaugeBuilder tickmarkGlowEnabled(final boolean TICKMARK_GLOW_ENABLED) {
        styleProperties.put("tickmarkGlowEnabled", new SimpleBooleanProperty(TICKMARK_GLOW_ENABLED));
        return this;
    }

    public final GaugeBuilder tickmarkGlowColor(final Color TICKMARK_GLOW_COLOR) {
        styleProperties.put("tickmarkGlowColor", new SimpleObjectProperty(TICKMARK_GLOW_COLOR));
        return this;
    }

    public final GaugeBuilder sectionsVisible(final boolean SECTIONS_VISIBLE) {
        styleProperties.put("sectionsVisible", new SimpleBooleanProperty(SECTIONS_VISIBLE));
        return this;
    }

    public final GaugeBuilder sectionsHighlighting(final boolean SECTIONS_HIGHLIGHTING) {
        styleProperties.put("sectionsHighlighting", new SimpleBooleanProperty(SECTIONS_HIGHLIGHTING));
        return this;
    }

    public final GaugeBuilder showSectionTickmarksOnly(final boolean SHOW_SECTION_TICKMARKS_ONLY) {
        styleProperties.put("showSectionTickmarksOnly", new SimpleBooleanProperty(SHOW_SECTION_TICKMARKS_ONLY));
        return this;
    }

    public final GaugeBuilder areasVisible(final boolean AREAS_VISIBLE) {
        styleProperties.put("areasVisible", new SimpleBooleanProperty(AREAS_VISIBLE));
        return this;
    }

    public final GaugeBuilder areasHighlighting(final boolean AREAS_HIGHLIGHTING) {
        styleProperties.put("areasHighlighting", new SimpleBooleanProperty(AREAS_HIGHLIGHTING));
        return this;
    }

    public final GaugeBuilder markersVisible(final boolean MARKERS_VISIBLE) {
        styleProperties.put("markersVisible", new SimpleBooleanProperty(MARKERS_VISIBLE));
        return this;
    }

    public final GaugeBuilder textureColor(final Color TEXTURE_COLOR) {
        styleProperties.put("textureColor", new SimpleObjectProperty<Color>(TEXTURE_COLOR));
        return this;
    }

    public final GaugeBuilder simpleGradientBaseColor(final Color SIMPLE_GRADIENT_BASE_COLOR) {
        styleProperties.put("simpleGradientBaseColor", new SimpleObjectProperty<Color>(SIMPLE_GRADIENT_BASE_COLOR));
        return this;
    }

    public final GaugeBuilder titleVisible(final boolean TITLE_VISIBLE) {
        styleProperties.put("titleVisible", new SimpleBooleanProperty(TITLE_VISIBLE));
        return this;
    }

    public final GaugeBuilder unitVisible(final boolean UNIT_VISIBLE) {
        styleProperties.put("unitVisible", new SimpleBooleanProperty(UNIT_VISIBLE));
        return this;
    }

    public final GaugeBuilder trendVisible(final boolean TREND_VISIBLE) {
        styleProperties.put("trendVisible", new SimpleBooleanProperty(TREND_VISIBLE));
        return this;
    }

    public final GaugeBuilder trendUpColor(final Color TREND_UP_COLOR) {
        styleProperties.put("trendUpColor", new SimpleObjectProperty<Color>(TREND_UP_COLOR));
        return this;
    }

    public final GaugeBuilder trendSteadyColor(final Color TREND_STEADY_COLOR) {
        styleProperties.put("trendSteadyColor", new SimpleObjectProperty<Color>(TREND_STEADY_COLOR));
        return this;
    }

    public final GaugeBuilder trendDownColor(final Color TREND_DOWN_COLOR) {
        styleProperties.put("trendDownColor", new SimpleObjectProperty<Color>(TREND_DOWN_COLOR));
        return this;
    }
}
