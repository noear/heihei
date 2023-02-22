//
//  ViewController.h
//  heihei
//
//  Created by 谢月甲 on 2017/8/3.
//  Copyright © 2017年 noear. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController{

}
    
@property (weak, nonatomic) IBOutlet UILabel *userID;
@property (weak, nonatomic) IBOutlet UITextField *userKey;
    
-(IBAction)btnSave_click;

+(void)tryAlert;

@end

