package com.ai.slp.user.util;

import com.ai.opt.sdk.sequence.util.SeqUtil;
import com.ai.slp.user.constants.SequenceCodeConstants;

/**
 * 用户SequenceCode生成工具
 */
public final class SequenceUtil {

    public static String createApiSeqId() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_API_INFO$API_SEQ_ID$SEQ,
                18);
    }

    public static String createBankSeqId() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_BANK_INFO$BANK_SEQ_ID$SEQ,
                18);
    }

    public static String createContactSeqId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_CONTACTS_INFO$CONTACT_SEQ_ID$SEQ, 18);
    }

    public static String createLoginSeqId() {
        return SeqUtil
                .getNewId(SequenceCodeConstants.UserSequenceCode.UC_LOGIN_LOG$LOGIN_SEQ_ID$SEQ, 18);
    }

    public static String createInfoSpecialId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_SPECIAL_INFO$INFO_SPECIAL_ID$SEQ, 18);
    }

    public static String createStateChgId() {
        return SeqUtil
                .getNewId(SequenceCodeConstants.UserSequenceCode.UC_STATE_CHG$STATE_CHG_ID$SEQ, 18);
    }

    /**
     * UC_TEL_GROUP
     */
    public static String createSeq1() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_TEL_GROUP$SEQ$SEQ, 18);
    }

    public static String createUserId() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_USER$USER_ID$SEQ, 18);
    }

    public static String createAgreeSeqId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_USER_AGREE$AGREE_SEQ_ID$SEQ, 18);
    }

    public static String createFavoriteSeqId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_USER_AGREE$AGREE_SEQ_ID$SEQ, 18);
    }

    public static String createInfoSeqId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_USER_MESSAGE$INFO_SEQ_ID$SEQ, 18);
    }

    /**
     * UC_USER_PHONEBOOKS
     */
    public static String createSeq2() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_USER_PHONEBOOKS$SEQ$SEQ,
                18);
    }

    public static String createSafariSeqId() {
        return SeqUtil.getNewId(
                SequenceCodeConstants.UserSequenceCode.UC_USER_SAFARI$SAFARI_SEQ_ID$SEQ, 18);
    }

    public static String createCardSeqId() {
        return SeqUtil.getNewId(SequenceCodeConstants.UserSequenceCode.UC_USER_SUBS$CARD_SEQ_ID$SEQ,
                18);
    }
}
