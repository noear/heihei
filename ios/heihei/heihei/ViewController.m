//
//  ViewController.m
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import "ViewController.h"
#import "JPUSHService.h"
#import "Session.h"
#import "HintUtil.h"
#import "CallUtil.h"
#import "Setting.h"

@interface ViewController ()

@end

static ViewController* _g;

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    _g = self;

    [CallUtil asynCall:500 fun:^{
        _userID.text = [JPUSHService registrationID];
        _userKey.text = [Session userName];
        
        [self doAlert];
    }];
    
}

-(void)doAlert {
    NSString* msg = [Setting getString:@"msg"];
    if(msg && msg.length>0){
        [HintUtil show:self txt:msg];
    }
    
    [Setting setString:@"msg" value:@""];
}

+(void)tryAlert{
    if(_g){
        [_g doAlert];
    }
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
    
-(IBAction)btnSave_click{
    [Session setUserName:_userKey.text];
    
    if(_userKey.text && _userKey.text.length>0){
        [JPUSHService setAlias:_userKey.text completion:^(NSInteger iResCode, NSString *iAlias, NSInteger seq) {
            [HintUtil show:self txt:@"操作成功"];
        } seq:1];
    }else{
        [JPUSHService deleteAlias:^(NSInteger iResCode, NSString *iAlias, NSInteger seq) {
            [HintUtil show:self txt:@"操作成功"];
        } seq:1];
    }
    
    [_userKey resignFirstResponder];
    
    
    
    
}


@end
