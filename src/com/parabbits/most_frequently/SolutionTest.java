package com.parabbits.most_frequently;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void sampleTests() {
        String text = "VUxWh;Zwv tycJoqlP;Zwv pIclP VUxWh_Zwv mfWk'KKd,iXrfGH_VUxWh:Zwv;nzSKsbfUCV VUxWh GYA Zwv?SKeblF tycJoqlP Zwv?nzSKsbfUCV!nzSKsbfUCV-VUxWh-VUxWh yPfL'FjXc_yPfL'FjXc nzSKsbfUCV VUxWh yPfL'FjXc-Zwv Zwv tycJoqlP?Zwv.Zwv Zwv.iXrfGH yPfL'FjXc nzSKsbfUCV nzSKsbfUCV/nzSKsbfUCV VUxWh_mfWk'KKd-VUxWh Zwv.Zwv nzSKsbfUCV nzSKsbfUCV VUxWh:yPfL'FjXc/tycJoqlP iXrfGH VUxWh mfWk'KKd-iXrfGH-nzSKsbfUCV pIclP?VUxWh_GYA SKeblF,mfWk'KKd VUxWh iXrfGH?Zwv nzSKsbfUCV iXrfGH;yPfL'FjXc Zwv SKeblF VUxWh:GYA-VUxWh?nzSKsbfUCV nzSKsbfUCV;GYA_SKeblF!VUxWh/nzSKsbfUCV VUxWh nzSKsbfUCV.nzSKsbfUCV/mfWk'KKd_Zwv/VUxWh pIclP/iXrfGH_mfWk'KKd Zwv Zwv,VUxWh Zwv.tycJoqlP nzSKsbfUCV.VUxWh GYA tycJoqlP;yPfL'FjXc.iXrfGH pIclP iXrfGH,pIclP iXrfGH-SKeblF nzSKsbfUCV_nzSKsbfUCV,iXrfGH VUxWh.VUxWh fBdcyqKDX pIclP:nzSKsbfUCV tycJoqlP nzSKsbfUCV iXrfGH.nzSKsbfUCV Zwv/nzSKsbfUCV iXrfGH Zwv-VUxWh.mfWk'KKd!GYA;iXrfGH;yPfL'FjXc?nzSKsbfUCV iXrfGH_tycJoqlP Zwv SKeblF/Zwv SKeblF nzSKsbfUCV:nzSKsbfUCV iXrfGH_pIclP_iXrfGH-iXrfGH tycJoqlP VUxWh VUxWh VUxWh!Zwv Zwv pIclP iXrfGH pIclP mfWk'KKd!Zwv pIclP Zwv SKeblF pIclP yPfL'FjXc nzSKsbfUCV/nzSKsbfUCV VUxWh iXrfGH mfWk'KKd Zwv yPfL'FjXc;yPfL'FjXc \n" +
                "kJDUQLOBgN/YoMli-YoMli.YoMli hofSkWot;bag'bIb:hofSkWot bag'bIb,hofSkWot bag'bIb,bag'bIb!bag'bIb,hpQLk kJDUQLOBgN hpQLk/YoMli xefyfi!OVyvqFA hofSkWot:xefyfi dXgoo xefyfi OVyvqFA OVyvqFA:kJDUQLOBgN_YoMli,YoMli YoMli YoMli?OVyvqFA/OVyvqFA kJDUQLOBgN eavRTT.fOkjORxB_dXgoo.xefyfi xefyfi IgTPIPUf'C/hpQLk OVyvqFA.hofSkWot_dXgoo IgTPIPUf'C.YoMli kJDUQLOBgN/hpQLk!xefyfi,dXgoo:hofSkWot kJDUQLOBgN bag'bIb/xefyfi Pwiiq.hofSkWot,hofSkWot YoMli kJDUQLOBgN Pwiiq,xefyfi.hofSkWot fOkjORxB kJDUQLOBgN kJDUQLOBgN fOkjORxB-kJDUQLOBgN!bag'bIb kJDUQLOBgN bag'bIb fOkjORxB,hofSkWot kJDUQLOBgN.dXgoo_hpQLk IgTPIPUf'C bag'bIb:Pwiiq!dXgoo/kJDUQLOBgN xefyfi fOkjORxB!fOkjORxB YoMli bag'bIb,JN'cLZMQ?YoMli,bag'bIb?IgTPIPUf'C Pwiiq-hpQLk/eavRTT.kJDUQLOBgN!IgTPIPUf'C xefyfi xefyfi kJDUQLOBgN?Pwiiq hofSkWot OVyvqFA:hofSkWot,Pwiiq-Pwiiq YoMli bag'bIb IgTPIPUf'C_OVyvqFA;fOkjORxB-YoMli/dXgoo kJDUQLOBgN Pwiiq?Pwiiq:dXgoo hofSkWot!dXgoo hofSkWot kJDUQLOBgN-fOkjORxB bag'bIb dXgoo xefyfi_Pwiiq OVyvqFA-eavRTT kJDUQLOBgN!xefyfi_YoMli hpQLk.hofSkWot Pwiiq!fOkjORxB Pwiiq IgTPIPUf'C?dXgoo:YoMli!YoMli hofSkWot hofSkWot;hofSkWot xefyfi.dXgoo bag'bIb!IgTPIPUf'C-Pwiiq Pwiiq IgTPIPUf'C OVyvqFA?xefyfi xefyfi-dXgoo?dXgoo bag'bIb-IgTPIPUf'C YoMli fOkjORxB,kJDUQLOBgN;kJDUQLOBgN hofSkWot dXgoo,Pwiiq hofSkWot:hpQLk fOkjORxB dXgoo Pwiiq!IgTPIPUf'C dXgoo xefyfi xefyfi_Pwiiq hofSkWot hofSkWot-IgTPIPUf'C Pwiiq Pwiiq xefyfi!kJDUQLOBgN dXgoo OVyvqFA?IgTPIPUf'C/IgTPIPUf'C:Pwiiq;IgTPIPUf'C_OVyvqFA fOkjORxB_YoMli hofSkWot xefyfi;dXgoo dXgoo-Pwiiq/kJDUQLOBgN_dXgoo!dXgoo Pwiiq YoMli Pwiiq dXgoo_xefyfi:hpQLk/Pwiiq:Pwiiq bag'bIb-hofSkWot dXgoo-dXgoo_fOkjORxB xefyfi xefyfi kJDUQLOBgN?kJDUQLOBgN YoMli hofSkWot kJDUQLOBgN YoMli YoMli xefyfi YoMli fOkjORxB Pwiiq,JN'cLZMQ/OVyvqFA hofSkWot xefyfi/Pwiiq/IgTPIPUf'C fOkjORxB xefyfi bag'bIb dXgoo:fOkjORxB YoMli/xefyfi!Pwiiq_xefyfi hpQLk?YoMli xefyfi Pwiiq kJDUQLOBgN dXgoo ";
        TopWords.top3(text);
        assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertEquals(Arrays.asList("won't", "wont"),  TopWords.top3("  //wont won't won't "));
        assertEquals(Arrays.asList("e"),              TopWords.top3("  , e   .. "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  ...  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '  "));
        assertEquals(Arrays.asList(),                 TopWords.top3("  '''  "));
        assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) ));

    }
}
