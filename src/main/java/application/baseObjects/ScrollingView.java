package application.baseObjects;

import net.miginfocom.swing.MigLayout;
import org.apache.commons.lang3.ArrayUtils;
import utils.LangHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static utils.LangHandler.get;

public abstract class ScrollingView<T extends BaseModel> extends BaseView<T> {

    final JPanel listPanel = new JPanel();
    final JPanel scrollingPanel = new JPanel();
    final JScrollPane scrollPane = new JScrollPane(scrollingPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    private final Map<String, Map<String, Map<JComponent, String>>> guiCategories = new LinkedHashMap<>();

    public ScrollingView(T model) {
        super(model);
        setLayout(null);
        listPanel.setBounds(0, 0, 960, 1080);
        scrollPane.setBounds(960, 0, 960, 950);
        scrollingPanel.setBounds(0, 0, 5000, 1080);
        listPanel.setLayout(null);
        MigLayout migLayout = new MigLayout("wrap 4", "10[250px]10[fill,grow]10[250px]10[fill,grow]", "");
        scrollingPanel.setLayout(migLayout);
        add(listPanel);
        add(scrollPane);
    }

    public void updateGUI() {
        Set<String> categories = guiCategories.keySet();
        for(String string : categories) {
            final JLabel label = new JLabel(get(string.replace("CATEGORY_", "")));
            scrollingPanel.add(label);
            final JCheckBox checkBox = new JCheckBox();
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AtomicReference<JComponent> lastObject = new AtomicReference<>(checkBox);
                    if(checkBox.isSelected()) {
                        guiCategories.get(string).forEach((key, value) -> {
                            for (Map.Entry<JComponent, String> entry : guiCategories.get(string).get(key).entrySet()) {
                                JComponent key1 = entry.getKey();
                                String value1 = entry.getValue();
                                scrollingPanel.add(key1, value1, ArrayUtils.indexOf(scrollingPanel.getComponents(), lastObject.get()) + 1);
                                lastObject.set(key1);
                            }
                        });
                    } else {
                        guiCategories.get(string).forEach((key, value) -> {
                            guiCategories.get(string).get(key).forEach((key1, value1) -> {
                                scrollingPanel.remove(key1);
                            });
                        });
                    }
                    scrollingPanel.revalidate();
                    scrollingPanel.repaint();
                }
            });
            scrollingPanel.add(checkBox, "wrap");
        }
    }

    public void addCategory(String id) {
        guiCategories.put(id, new LinkedHashMap<>());
    }

    private Map<String, Map<JComponent, String>> getComponentMapFromCategory(String id) {
        return guiCategories.get(id);
    }

    public List<JComponent> getComponentsFromCategory(String categoryId) {
        return getComponentMapFromCategory(categoryId).values().stream().map(Map::keySet).flatMap(Set::stream).collect(Collectors.toList());
    }

    public JComponent getComponent(String categoryId, String componentId) {
        return getComponentMapFromCategory(categoryId).get(componentId).keySet().iterator().next();
    }

    public void addSLabel(String categoryId, String labelId, String text) {
        addSLabel(categoryId, labelId, text, "");
    }

    public void addSLabel(String categoryId, String labelId, String text, String constraints) {
        final JLabel label = new JLabel(get(labelId.replace("LABEL_", "")));
        addComponent(categoryId, labelId, label, constraints);
    }

    public void addSSingletonTextfield(String categoryId, String textfieldId, String labelId, String labelText) {
        addSTextfield(categoryId, textfieldId, labelId, labelText, "wrap, span 3");
    }

    public void addSTextfield(String categoryId, String textfieldId, String labelId, String labelText) {
        addSTextfield(categoryId, textfieldId, labelId, labelText, "");
    }

    public void addSTextfield(String categoryId, String textfieldId, String labelId, String labelText, String constraints) {
        addSLabel(categoryId, labelId, labelText);
        final JTextField textField = new JTextField();
        addComponent(categoryId, textfieldId, textField, constraints);
    }

    private void addComponent(String categoryId, String labelId, JComponent component, String constraints) {
        guiCategories.get(categoryId).put(labelId, new LinkedHashMap<>(Map.of(component, constraints)));
    }

    private void addToScrollingPanel(JComponent component, String constraints) {
        if(!constraints.isEmpty()) {
            scrollingPanel.add(component, constraints);
        } else {
            scrollingPanel.add(component);
        }
    }
}