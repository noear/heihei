//
//  HintUtil.m
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import "HintUtil.h"
#import <Toast/UIView+Toast.h>

@implementation HintUtil

+(void)show:(UIViewController*)from txt:(NSString*)txt{
    [from.view makeToast:txt];
}

+(void)show2:(UIViewController*)from txt:(NSString*)txt{
    [from.view makeToast:txt duration:3.0 position:CSToastPositionCenter style:nil];
}

+(void)alert:(UIViewController*)from txt:(NSString*)txt{
    
    UIAlertController *alertController = [UIAlertController alertControllerWithTitle:@"消息" message:txt preferredStyle:UIAlertControllerStyleAlert];
    
    UIAlertAction *cancelAction = [UIAlertAction actionWithTitle:@"关闭 " style:UIAlertActionStyleCancel handler:^(UIAlertAction * _Nonnull action) {
    }];
    
    [alertController addAction:cancelAction];
    
    [from presentViewController:alertController animated:YES completion:nil];
    
}

@end
