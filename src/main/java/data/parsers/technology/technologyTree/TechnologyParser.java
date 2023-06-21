package data.parsers.technology.technologyTree;

import data.objects.technology.technologyTree.Technology;
import data.parsers.BaseParser;

import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TechnologyParser extends BaseParser<Technology> {

    public static String PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR = "production_factory_max_efficiency_factor";
    public static String PATH = "path";
    public static String RESEARCH_COST = "research_cost";
    public static String START_YEAR = "start_year";
    public static String FOLDER = "folder";
    public static String CATEGORIES = "categories";
    public static String LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR = "line_change_production_efficiency_factor";
    public static String XOR = "XOR";
    public static String AI_WILL_DO = "ai_will_do";
    public static String EQUIPMENT_CONVERSION_SPEED = "equipment_conversion_speed";
    public static String ALLOW_BRANCH = "allow_branch";
    public static String INDUSTRIAL_CAPACITY_FACTORY = "industrial_capacity_factory";
    public static String INDUSTRIAL_CAPACITY_DOCKYARD = "industrial_capacity_dockyard";
    public static String GLOBAL_BUILDING_SLOTS_FACTOR = "global_building_slots_factor";
    public static String AI_RESEARCH_WEIGHTS = "ai_research_weights";
    public static String ENABLE_BUILDING = "enable_building";
    public static String SHOW_EFFECT_AS_DESC = "show_effect_as_desc";
    public static String ON_RESEARCH_COMPLETE = "on_research_complete";
    public static String PRODUCTION_SPEED_BUILDINGS_FACTOR = "production_speed_buildings_factor";
    public static String INDUSTRY_REPAIR_FACTOR = "industry_repair_factor";
    public static String LOCAL_RESOURCES_FACTOR = "local_resources_factor";
    public static String FUEL_GAIN_FACTOR = "fuel_gain_factor";
    public static String FUEL_GAIN_FACTOR_FROM_STATES = "fuel_gain_factor_from_states";
    public static String INDUSTRY_AIR_DAMAGE_FACTOR = "industry_air_damage_factor";
    public static String PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR = "production_factory_start_efficiency_factor";
    public static String PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR = "production_factory_efficiency_gain_factor";

    private final TechnologyPathParser technologyPathParser = new TechnologyPathParser();
    private final TechnologyFolderParser technologyFolderParser = new TechnologyFolderParser();
    private final TechnologyCategoriesParser technologyCategoriesParser = new TechnologyCategoriesParser();
    private final TechnologyXORParser technologyXORParser = new TechnologyXORParser();
    private final TechnologyAiWillDoParser technologyAiWillDoParser = new TechnologyAiWillDoParser();
    private final TechnologyAllowBranchParser technologyAllowBranchParser = new TechnologyAllowBranchParser();
    private final TechnologyAiResearchWeightsParser technologyAiResearchWeightsParser = new TechnologyAiResearchWeightsParser();
    private final TechnologyEnableBuildingParser technologyEnableBuildingParser = new TechnologyEnableBuildingParser();
    private final TechnologyOnResearchCompleteParser technologyOnResearchCompleteParser = new TechnologyOnResearchCompleteParser();

    @Override
    public Technology parse(List<String> lines) {

        final Technology technology = new Technology();

        for(int i = 0; i < lines.size(); i++) {

            final String tempLine = lines.get(i);

            if(i == 0) {
                technology.setName(tempLine.replace(TABULATOR_STRING, "").replace(FREE_EQUAL_SIGN + OPENING_BRACKET, EMPTY_STRING));
                continue;
            }

            if(tempLine.contains(PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR)) {
                technology.setProductionFactoryMaxEfficiencyFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, PRODUCTION_FACTORY_MAX_EFFICIENCY_FACTOR, 2)));
                continue;
            }

            if (tempLine.contains(PATH)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.getTechnologyPaths().add(technologyPathParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(RESEARCH_COST)) {
                technology.setResearchCost(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, RESEARCH_COST, 2)));
                continue;
            }

            if(tempLine.contains(START_YEAR)) {
                technology.setStartYear(parseInt(replaceTabulatorAndFreeEqualSign(tempLine, START_YEAR, 2)));
                continue;
            }

            if(tempLine.contains(FOLDER)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setFolder(technologyFolderParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(CATEGORIES)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setCategories(technologyCategoriesParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR)) {
                technology.setLineChangeProductionEfficiencyFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, LINE_CHANGE_PRODUCTION_EFFICIENCY_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(XOR)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setXor(technologyXORParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(AI_WILL_DO)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setAiWillDo(technologyAiWillDoParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(EQUIPMENT_CONVERSION_SPEED)) {
                technology.setEquipmentConversionSpeed(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, EQUIPMENT_CONVERSION_SPEED, 2)));
                continue;
            }

            if(tempLine.contains(ALLOW_BRANCH)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setAllowBranch(technologyAllowBranchParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(INDUSTRIAL_CAPACITY_FACTORY)) {
                technology.setIndustrialCapacityFactory(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, INDUSTRIAL_CAPACITY_FACTORY, 2)));
                continue;
            }

            if(tempLine.contains(INDUSTRIAL_CAPACITY_DOCKYARD)) {
                technology.setIndustrialCapacityDockyard(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, INDUSTRIAL_CAPACITY_DOCKYARD, 2)));
                continue;
            }

            if(tempLine.contains(GLOBAL_BUILDING_SLOTS_FACTOR)) {
                technology.setGlobalBuildingSlotsFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, GLOBAL_BUILDING_SLOTS_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(AI_RESEARCH_WEIGHTS)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setAiResearchWeights(technologyAiResearchWeightsParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(ENABLE_BUILDING)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setEnableBuilding(technologyEnableBuildingParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(SHOW_EFFECT_AS_DESC)) {
                technology.setShowEffectAsDesc(replaceTabulatorAndFreeEqualSign(tempLine, SHOW_EFFECT_AS_DESC, 2).equals("yes"));
                continue;
            }

            if(tempLine.contains(ON_RESEARCH_COMPLETE)) {
                final int endingPoint = calculateEndingObjectPhase(lines, i, 2);
                final List<String> lineStack = createLineStack(lines, i, endingPoint);
                technology.setOnResearchComplete(technologyOnResearchCompleteParser.parse(lineStack));
                i += lineStack.size() - 1;
                continue;
            }

            if(tempLine.contains(PRODUCTION_SPEED_BUILDINGS_FACTOR)) {
                technology.setProductionSpeedBuildingsFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, PRODUCTION_SPEED_BUILDINGS_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(INDUSTRY_REPAIR_FACTOR)) {
                technology.setIndustryRepairFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, INDUSTRY_REPAIR_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(LOCAL_RESOURCES_FACTOR)) {
                technology.setLocalResourcesFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, LOCAL_RESOURCES_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(FUEL_GAIN_FACTOR_FROM_STATES)) {
                technology.setFuelGainFactorFromState(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, FUEL_GAIN_FACTOR_FROM_STATES, 2)));
                continue;
            }

            if(tempLine.contains(FUEL_GAIN_FACTOR)) {
                technology.setFuelGainFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, FUEL_GAIN_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(INDUSTRY_AIR_DAMAGE_FACTOR)) {
                technology.setIndustryAirDamageFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, INDUSTRY_AIR_DAMAGE_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR)) {
                technology.setProductionFactoryStartEfficiencyFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, PRODUCTION_FACTORY_START_EFFICIENCY_FACTOR, 2)));
                continue;
            }

            if(tempLine.contains(PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR)) {
                technology.setProductionFactoryEfficiencyGainFactor(parseDouble(replaceTabulatorAndFreeEqualSign(tempLine, PRODUCTION_FACTORY_EFFICIENCY_GAIN_FACTOR, 2)));
            }
        }

        return technology;
    }
}
