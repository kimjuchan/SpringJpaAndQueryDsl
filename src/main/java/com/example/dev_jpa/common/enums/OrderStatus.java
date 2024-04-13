package com.example.dev_jpa.common.enums;

public enum OrderStatus {
    //결제완료.
    PAYED,
    //전체취소
    CANCEL,
    //부분취소
    PART_CANCEL,
    //배송중
    SHIPPING,
    //배송완료
    SHIPPING_FINISH,
    //구매확정(배송완료 시점 7일이후)
    CONFIRM;

}
